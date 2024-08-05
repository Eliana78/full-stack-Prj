//// SEARCH BY PRICE RANGE

// Ensure form submission doesn't reload the page
document
  .getElementById("priceRangeForm")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form from submitting
    fetchAndDisplayGames();
  });

function fetchAndDisplayGames() {
  // Parse values to ensure they are numbers
  const minPrice = parseFloat(document.getElementById("minPrice").value);
  const maxPrice = parseFloat(document.getElementById("maxPrice").value);

  const gamesDiv = document.querySelector("#game-list");
  const url = `http://localhost:9007/api/games/priceRange/${minPrice}/${maxPrice}`;

  if (isNaN(minPrice) || isNaN(maxPrice)) {
    alert("Please enter valid numeric values for both prices.");
    return;
  }

  fetch(url)
    .then((response) => {
      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
      return response.json();
    })
    .then((data) => {
      gamesDiv.innerHTML = "";

      if (data.length === 0) {
        gamesDiv.innerHTML = "<p>No games found.</p>";
      } else {
        data.forEach((game) => {
          let card = createGameCard(game);
          gamesDiv.innerHTML += card;
        });
        document.getElementById("minPrice").value = "";
        document.getElementById("maxPrice").value = "";
      }
    });
}

function createGameCard(game) {
  return `
        <div class="card m-3 bg-primary-subtle" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${game.titolo}</h5>
                <p class="card-text">${game.year}</p>
                <p class="card-text">${game.gameType}</p>
                <p class="card-text">Price: $${game.price.toFixed(2)}</p>
            </div>
        </div>
    `;
}
