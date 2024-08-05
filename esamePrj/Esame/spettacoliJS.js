function fetchSpettacoli() {
  fetch("http://localhost:9020/api/spettacoli")
    .then((response) => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then((spettacoli) => {
      const tuttiSpettacoliDiv = document.getElementById("tuttiSpettacoliDiv");
      tuttiSpettacoliDiv.innerHTML = "";

      spettacoli.forEach((spettacolo) => {
        const card = document.createElement("div");
        card.className = "col-md-4 mb-4";

        card.innerHTML = `
            <div class="card">
              <p class="card-body border border-danger">${spettacolo.titolo}
              <div class="card-body">
                <h5 class="card-title">Autore: ${spettacolo.autore}</h5>
                <p class="card-text"><strong>Descrizione:</strong>Regista: ${spettacolo.registra}</p>
                <p class="card-text"><strong>Descrizione:</strong>Regista: Prezzo: € ${spettacolo.prezzo}</p>
                <button class="btn btn-dark mt-2" onclick="prenotaSpettacolo('${spettacolo.codSpettacolo}')">Prenota</button>
              </div>
            </div>
          `;
        tuttiSpettacoliDiv.appendChild(card);
      });
    })
    .catch((error) => {
      console.error("Errore durante il fetch:", error);
    });
}

// Funzione per aggiungere uno spettacolo al local storage
function prenotaSpettacolo(codSpettacolo) {
  fetch("http://localhost:9020/api/spettacoli")
    .then((response) => response.json())
    .then((spettacoli) => {
      const spettacolo = spettacoli.find(
        (s) => s.codSpettacolo === codSpettacolo
      );
      if (spettacolo) {
        let carrello = JSON.parse(localStorage.getItem("carrello")) || [];
        carrello.push(spettacolo);
        localStorage.setItem("carrello", JSON.stringify(carrello));
        alert("Spettacolo aggiunto al carrello!");
      }
    })
    .catch((error) => {
      console.error("Errore durante la prenotazione:", error);
    });
}

fetchSpettacoli();
