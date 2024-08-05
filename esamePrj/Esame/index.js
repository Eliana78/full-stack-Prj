function fetchShows() {
  fetch("http://localhost:9020/api/teatri")
    .then((response) => {
      // Controlla se la risposta è ok e logga lo stato della risposta
      console.log("Response Status:", response.status);
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then((teatri) => {
      // Logga i dati ricevuti per controllare la struttura
      console.log("Data:", teatri);

      const topPicks = document.getElementById("topPicks");
      topPicks.innerHTML = ""; // Pulisce il contenitore

      teatri.forEach((teatro) => {
        const card = document.createElement("div");
        card.className = "col-md-4 mb-4";

        card.innerHTML = `
            <div class="card bg-dark text-white">
              <div class="card-body">
                <h5 class="card-title">${teatro.nome}</h5>
                <p class="card-text"><strong>Indirizzo:</strong> ${teatro.indirizzo}</p>
                <p class="card-text"><strong>Città:</strong> ${teatro.citta}</p>
                <p class="card-text"><strong>Telefono:</strong> ${teatro.telefono}</p>
                <a href="tel:${teatro.telefono}" class="btn btn-primary">Chiama</a>
              </div>
            </div>
          `;
        topPicks.appendChild(card);
      });
    })
    .catch((error) => {
      // Logga eventuali errori
      console.error("Errore durante il fetch:", error);
    });
}

fetchShows();
