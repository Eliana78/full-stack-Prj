//FETCH BY NAME-TITLE
const gamesSearchDiv = document.querySelector("#gamesSearchDiv");
const searchBtn = document.querySelector("#searchBtn");
const gamesByTitleURL = "http://localhost:9007/api/games/title/";

function getGamesByName() {
  const gameInputValue = document.querySelector("#search").value;

  fetch(gamesByTitleURL + encodeURIComponent(gameInputValue))
    .then((response) => response.json())
    .then((data) => {
      gamesSearchDiv.innerHTML = "";
      data.forEach((game) => {
        const card = createGameCard(game);
        gamesSearchDiv.innerHTML += card;
      });
    });
}

function createGameCard(game) {
  return `
    <div class="card m-3" style="width: 18rem;">
      <div class="card-body">
        <h5 class="card-title">${game.titolo}</h5>
        <p class="card-text">Year: ${game.year}</p>
        <p class="card-text">Type: ${game.gameType}</p>
        <p class="card-text">Price: $${game.price}</p>
      </div>
    </div>
  `;
}

searchBtn.addEventListener("click", getGamesByName);

////////////////////////////////////////////////////////////////////////////////////////

let gamesDiv = document.querySelector("#gamesDiv");

let allGamesURL = "http://localhost:9007/api/games";

// FETCH TO GET ALL <GAMES>

function getAllGames() {
  fetch(allGamesURL)
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      gamesDiv.innerHTML = "";

      data.forEach((game) => {
        const card = createGameCard(game);

        gamesDiv.innerHTML += card;
      });
    });
}

function createGameCard(game) {
  let card = `  
<div class="card m-3 bg-primary-subtle" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">${game.titolo}</h5>
    <p class="card-text">${game.year}</p>
    <p class="card-text">${game.gameType}</p>
     <p class="card-text">${game.price}</p>
  </div>
</div>
    `;
  return card;
}

getAllGames();
