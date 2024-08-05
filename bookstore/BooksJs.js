document.addEventListener("DOMContentLoaded", function () {
  const foundedBookDiv = document.querySelector("#foundedBook");
  const btnSearch = document.querySelector("#searchButton");

  // Endpoint per titolo
  const urlByTitolo = "http://localhost:9006/api/libri/titolo/";
  // Endpoint per id
  const urlById = "http://localhost:9006/api/libri/id/";
  // Endpoint per categoria
  const urlCategory = "http://localhost:9006/api/libri/categoria/";
  // Endpoint per tutti i libri
  const urlTuttiLibri = "http://localhost:9006/api/libri";
  const divTuttiLibri = document.querySelector("#divTuttiLibri");

  // Funzione di ricerca per titolo o id
  function searchByIdorTitle() {
    const searchValue = document.querySelector("#search").value.trim();

    // Controlla se l'input è un numero
    if (!isNaN(searchValue) && searchValue !== "") {
      // È un numero, quindi usa l'endpoint per ID
      fetch(urlById + searchValue)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Errore nella fetch per ID");
          }
          return response.json();
        })
        .then((data) => {
          const card = creaCardIdoTitolo(data);
          foundedBookDiv.innerHTML = card;
        })
        .catch((error) => {
          console.error("Errore nella fetch per ID:", error);
          foundedBookDiv.innerHTML = "Errore nella fetch per ID";
        });
    } else {
      // Non è un numero, quindi usa l'endpoint per titolo
      fetch(urlByTitolo + searchValue)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Errore nella fetch per titolo");
          }
          return response.json();
        })
        .then((data) => {
          const card = creaCardIdoTitolo(data);
          foundedBookDiv.innerHTML = card;
        })
        .catch((error) => {
          console.error("Errore nella fetch per titolo:", error);
          foundedBookDiv.innerHTML = "Errore nella fetch per titolo";
        });
    }
  }

  function creaCardIdoTitolo(libro) {
    return `
      <div class="card m-4 bg-body-secondary" style="width: 20rem">
         <div class="card-body">
             <h3 class="card-title">${libro.titolo}</h3>
             <p class="card-text mt-2">${libro.autore}</p>
             <img class="card-img-top" src="${libro.immagine}" alt="Immagine del libro">
             <p class="card-text mt-3">${libro.trama}</p>
             <button class="btn btn-dark add-to-cart mb-3" data-id="${libro.id}">Add to Cart</button>
         </div>
     </div>
    `;
  }

  btnSearch.addEventListener("click", searchByIdorTitle);

  // Funzione per ottenere i libri per categoria
  function handleCategoryClick(category) {
    const fetchUrl = `${urlCategory}${category.toUpperCase()}`;

    fetch(fetchUrl)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        divResultCategory.innerHTML = ""; // Clear previous results
        data.forEach((libro) => {
          const card = creaCardByCategory(libro);
          divResultCategory.innerHTML += card;
        });
      })
      .catch((error) => console.error("Error fetching books:", error));
  }

  function creaCardByCategory(libro) {
    return `
      <div class="card m-4 bg-body-secondary" style="width: 20rem">
         <div class="card-body">
             <h3 class="card-title">${libro.titolo}</h3>
             <p class="card-text mt-2">${libro.autore}</p>
             <img class="card-img-top" src="${libro.immagine}" alt="Immagine del libro">
             <p class="card-text mt-3">${libro.trama}</p>
             
             </div>
             <button class="btn btn-dark add-to-cart mb-3" data-id="${libro.id}">Add to Cart</button>
            
     </div>
    `;
  }

  // Funzione per ottenere tutti i libri
  function fetchAndDisplayBooks() {
    fetch(urlTuttiLibri)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        divTuttiLibri.innerHTML = "";
        data.forEach((libro) => {
          const card = createBookCard(libro);
          divTuttiLibri.innerHTML += card;
        });
      })
      .catch((error) => console.error("Error fetching books:", error));
  }

  function createBookCard(libro) {
    return `
      <div class="card m-4 bg-body-secondary" style="width: 20rem">
         <div class="card-body">
             <h3 class="card-title">${libro.titolo}</h3>
             <p class="card-text mt-2">${libro.autore}</p>
             <img class="card-img-top" src="${libro.immagine}" alt="Immagine del libro">
             <p class="card-text mt-3">${libro.trama}</p>
         </div>
         <button class="btn btn-dark add-to-cart mb-3" data-id="${libro.id}">Add to Cart</button>
      </div>
    `;
  }

  // Funzione per gestire l'aggiunta al carrello
  function handleAddToCart(event) {
    if (event.target.classList.contains("add-to-cart")) {
      const bookId = event.target.getAttribute("data-id");

      // Ottieni il carrello corrente da localStorage o inizializza un array vuoto
      let cart = JSON.parse(localStorage.getItem("cart")) || [];

      // Controlla se il libro è già nel carrello
      if (!cart.includes(bookId)) {
        cart.push(bookId);
        localStorage.setItem("cart", JSON.stringify(cart));
      }

      // Reindirizza alla pagina del carrello
      window.location.href = "cart.html";
    }
  }

  // Event delegation per gestire i click sui bottoni "Add to Cart"
  document.body.addEventListener("click", handleAddToCart);

  // Aggiungi event listeners ai bottoni delle categorie
  const btnFantasy = document.querySelector("#fantasy");
  const btnHorror = document.querySelector("#horror");
  const btnRomanzo = document.querySelector("#romanzo");
  const btnScienza = document.querySelector("#scienza");
  const btnBiografia = document.querySelector("#biografia");
  const btnStoria = document.querySelector("#storia");
  const divResultCategory = document.querySelector("#resultCategoryBook");

  btnFantasy.addEventListener("click", () => handleCategoryClick("FANTASY"));
  btnHorror.addEventListener("click", () => handleCategoryClick("HORROR"));
  btnRomanzo.addEventListener("click", () => handleCategoryClick("ROMANZO"));
  btnScienza.addEventListener("click", () => handleCategoryClick("SCIENZA"));
  btnBiografia.addEventListener("click", () =>
    handleCategoryClick("BIOGRAFIA")
  );
  btnStoria.addEventListener("click", () => handleCategoryClick("STORIA"));

  // Fetch e visualizza tutti i libri quando la pagina viene caricata
  fetchAndDisplayBooks();
});
