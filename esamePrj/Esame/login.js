document.addEventListener("DOMContentLoaded", () => {
  const popupbox = document.getElementById("popupbox");
  const loginForm = document.getElementById("loginForm");
  const errorMessage = document.getElementById("errorMessage");
  const pageContent = document.getElementById("pageContent");

  if (!popupbox || !loginForm || !errorMessage || !pageContent) {
    console.error("One or more DOM elements are missing.");
    return;
  }

  popupbox.style.display = "flex";

  loginForm.onsubmit = async (event) => {
    event.preventDefault();

    const clientCode = parseInt(
      document.getElementById("clientCode").value.trim(),
      10
    );

    if (isNaN(clientCode) || clientCode <= 0) {
      errorMessage.textContent = "Please enter a valid client code.";
      return;
    }

    try {
      const response = await fetch("http://localhost:9020/api/clienti");
      if (!response.ok) {
        throw new Error("Network response was not ok.");
      }

      const clienti = await response.json();
      const cliente = clienti.find((cliente) => cliente.id === clientCode);

      if (cliente) {
        popupbox.style.display = "none"; // Nascondi il modale
        pageContent.style.display = "block"; // Mostra il contenuto della pagina
        document.body.style.overflow = "auto"; // Assicurati che il corpo della pagina possa scorrere
      } else {
        errorMessage.textContent = "Client code not found.";
      }
    } catch (error) {
      errorMessage.textContent = `Error: ${error.message}`;
      console.error("Error:", error);
    }
  };

  window.onclick = (event) => {
    if (event.target === popupbox) {
      event.stopPropagation();
    }
  };
});
