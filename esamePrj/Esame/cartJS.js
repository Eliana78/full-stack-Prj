function mostraCarrello() {
  const carrelloDiv = document.getElementById("carrelloDiv");
  carrelloDiv.innerHTML = "";

  const carrello = JSON.parse(localStorage.getItem("carrello")) || [];

  if (carrello.length === 0) {
    carrelloDiv.innerHTML =
      "<p class='text-center text-white'>Il carrello è vuoto.</p>";
    return;
  }

  carrello.forEach((spettacolo) => {
    const card = document.createElement("div");
    card.className = "col-md-4 mb-4";

    card.innerHTML = `
          <div class="card border border-danger">
            <div class="card-body">
              <h5 class="card-title">Titolo: ${spettacolo.titolo}</h5>
              <p class="card-text"><strong>Autore:</strong> ${spettacolo.autore}</p>
              <p class="card-text"><strong>Regista:</strong> ${spettacolo.registra}</p>
              <p class="card-text"><strong>Prezzo:</strong> € ${spettacolo.prezzo}</p>
              <button class="btn btn-dark mt-2" onclick="rimuoviSpettacolo('${spettacolo.codSpettacolo}')">Rimuovi</button>
            </div>
          </div>
        `;
    carrelloDiv.appendChild(card);
  });
}

function rimuoviSpettacolo(codSpettacolo) {
  let carrello = JSON.parse(localStorage.getItem("carrello")) || [];
  carrello = carrello.filter(
    (spettacolo) => spettacolo.codSpettacolo !== codSpettacolo
  );
  localStorage.setItem("carrello", JSON.stringify(carrello));
  mostraCarrello();
}

mostraCarrello();

document
  .getElementById("acquistoForm")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    const dataOra = document.getElementById("dataOra").value;
    const quantita = document.getElementById("quantita").value;
    const tipoPagamento = document.getElementById("tipoPagamento").value;
    const codiceCliente = document.getElementById("codiceCliente").value;
    const codiceReplica = document.getElementById("codiceReplica").value;

    if (
      !dataOra ||
      !quantita ||
      !tipoPagamento ||
      !codiceCliente ||
      !codiceReplica
    ) {
      console.error("Tutti i campi devono essere compilati.");
      alert("Per favore, compila tutti i campi.");
      return;
    }

    const prenotazione = {
      data_ora: dataOra,
      quantita: parseInt(quantita, 10),
      tipo_pagamento: tipoPagamento.toUpperCase(),
      cliente: {
        id: parseInt(codiceCliente, 10),
      },
      replica: {
        id: parseInt(codiceReplica, 10),
      },
    };

    // Invia i dati al server
    fetch("http://localhost:9020/api/biglietti/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(prenotazione),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(
            "Errore nella risposta del server: " + response.statusText
          );
        }
        return response.json();
      })
      .then((data) => {
        console.log("Risposta dal server:", data);
        alert("Prenotazione completata con successo!");
        document.getElementById("acquistoForm").reset();
      })
      .catch((error) => {
        console.error("Errore durante la prenotazione:", error);
        alert("Errore durante la prenotazione. Riprova più tardi.");
      });
  });
