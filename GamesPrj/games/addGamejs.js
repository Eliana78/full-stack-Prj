//ADD EVENT LISTENER TO THE DOCUMENT AS IT NEED MORE TIME TO BE ABLE TO LOAD THE PAGE

////ADD A GAME

document.addEventListener("DOMContentLoaded", () => {
  const addGameForm = document.querySelector("#addGameForm");
  const addGameURL = "http://localhost:9007/api/games/add";
  const btnSubmit = document.querySelector("#btnSubmit");

  function createOBJgame(event) {
    // Retrieve the form input values
    const title = document.querySelector("#title").value;
    const year = document.querySelector("#year").value;
    const gameType = document.querySelector("#game_type").value;
    const price = document.querySelector("#price").value;

    // Create an object with the input values
    const newGame = {
      titolo: title,
      year: parseInt(year),
      gameType: gameType,
      price: parseFloat(price),
    };

    fetch(addGameURL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newGame),
    })
      .then((response) => response.json())
      .then((data) => {
        // Reset the form fields
        addGameForm.reset();
      });
    event.preventDefault();
  }

  btnSubmit.addEventListener("click", createOBJgame);
});

////////////// DELETE BY ID

document.addEventListener("DOMContentLoaded", () => {
  const btnDelete = document.querySelector("#btnDelete");

  function deleteGame() {
    const gameId = document.querySelector("#insertedId").value.trim();

    fetch(`http://localhost:9007/api/games/delete/${gameId}`, {
      method: "DELETE",
    }).finally(() => {
      // Clear the input field after sending the request
      document.querySelector("#insertedId").value = "";
    });
  }

  btnDelete.addEventListener("click", deleteGame);
});
