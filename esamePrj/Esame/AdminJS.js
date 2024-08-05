document.addEventListener("DOMContentLoaded", function () {
  fetchBiglietti();
});

function fetchBiglietti() {
  fetch("http://localhost:9020/api/biglietti")
    .then((response) => {
      if (!response.ok) {
        throw new Error(
          "Errore nella risposta del server: " + response.statusText
        );
      }
      return response.json();
    })
    .then((biglietti) => {
      const tableBody = document.getElementById("bigliettiTableBody");
      tableBody.innerHTML = "";

      biglietti.forEach((biglietto) => {
        const row = document.createElement("tr");

        // Aggiungi le celle alla riga
        row.innerHTML = `
            <td>${biglietto.id}</td>
            <td>${biglietto.date}</td>
            <td>${biglietto.quantita}</td>
            <td>${biglietto.tipoPagamento}</td>
            <td>${biglietto.cliente ? biglietto.cliente.nome : "N/A"}</td>
            <td>${biglietto.cliente ? biglietto.cliente.cognome : "N/A"}</td>
            <td>${biglietto.replica ? biglietto.replica.id : "N/A"}</td>
          `;

        tableBody.appendChild(row);
      });
    })
    .catch((error) => {
      console.error("Errore durante il fetch:", error);
      alert("Errore durante il recupero dei biglietti. Riprova più tardi.");
    });
}
