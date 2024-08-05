let urlTopSix = "http://localhost:9006/api/libri";

let divTopSix = document.querySelector("#topTripsDiv");

// fai la fetch richiamando la creaCardLibro cosi crea la card per ogni libro
// ma facendo il ciclo for fino a 6 lo limio a 6
function getLibri() {
  fetch(urlTopSix)
    .then((response) => response.json()) // Return the parsed JSON
    .then((data) => {
      // Clear existing content
      divTopSix.innerHTML = "";

      // Loop through the first 6 items or less if there are fewer than 6
      for (let i = 0; i < 6; i++) {
        let libro = data[i];
        let card = creaCardLibro(libro);
        divTopSix.innerHTML += card; // Append the card to the inner HTML
      }
    });
}
getLibri();

//crea card con libro
function creaCardLibro(libro) {
  let card = `
                     <div class="card m-4 bg-body-secondary" style="width: 20rem">
                        <div class="card-body">
                            <h3 class="card-title">${libro.titolo}</h3>
                            <p class="card-text mt-2">${libro.autore}</p>
                            <img class="card-img-top" src=${libro.immagine}>
                            <p class="card-text mt-3">${libro.trama}</p>
                        </div>
                    </div>
                `;
  return card;
}
