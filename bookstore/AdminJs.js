//////////////////search order by id

document.addEventListener("DOMContentLoaded", () => {
  console.log("DOM fully loaded and parsed");

  let foundedOrder = document.querySelector("#foundedOrder");
  let orderIdbtn = document.querySelector("#searchButtonId");
  let idInserted = document.querySelector("#searchBtn");

  function displayOrdine(ordine) {
    let card = `
            <div class="ordine-details">
                <h2>Ordine ID: ${ordine.id}</h2>
                <p>Quantità: ${ordine.quantita}</p>
                <h3>Libri:</h3>
                <ul>
                    ${ordine.libri
                      .map(
                        (libro) => `
                        <li>
                            <p>ID: ${libro.id}</p>
                            <p>Autore: ${libro.autore}</p>
                            <p>Titolo: ${libro.titolo}</p>
                            <p>Prezzo: ${libro.prezzo}</p>
                            <p>Categoria: ${libro.categoria}</p>
                        </li>
                    `
                      )
                      .join("")}
                </ul>
            </div>
        `;
    return card;
  }

  function fetchOrdine() {
    let ordineId = idInserted.value;
    console.log("ID inserito:", ordineId); // Debug

    if (!ordineId) {
      alert("Please enter an ordine ID.");
      return;
    }

    fetch(`http://localhost:9006/api/ordini/${ordineId}`)
      .then((response) => {
        return response.json();
      })

      .then((ordine) => {
        foundedOrder.innerHTML = "";
        const card = displayOrdine(ordine);
        foundedOrder.innerHTML = card;
      });
  }

  orderIdbtn.addEventListener("click", fetchOrdine);
});

//////////////////////////// display all order

let allOrderDiv = document.querySelector("#allOrders");

let allOrdersUrl = "http://localhost:9006/api/ordini";

function allOrders() {
  fetch(allOrdersUrl)
    .then((data) => data.json())
    .then((response) => {
      response.forEach((ordine) => {
        allOrderDiv.appendChild(OrderList(ordine));
      });
    })
    .catch((error) => {
      console.error("Error fetching orders:", error);
      allOrderDiv.innerHTML = "<p>Error fetching orders.</p>";
    });
}

function OrderList(ordine) {
  let colDiv = document.createElement("div");
  colDiv.classList.add("col-md-3", "mb-4");

  let cardOrdine = `
    <div class="ordine-details bg-light border border-secondary p-3">
      <div class="card-body ">
        <h2 class="card-title ">Ordine id: ${ordine.id}</h2>
        <p class="card-text ">Quantità: ${ordine.quantita}</p>
        <h3 clas="">Libri:</h3>
        <ul class="list-group list-group-flush">
          ${ordine.libri
            .map(
              (libro) => `
            <li class="list-group-item">
              <p>id: ${libro.id}</p>
              <p>Autore: ${libro.autore}</p>
              <p>Titolo: ${libro.titolo}</p>
              <p>Prezzo: ${libro.prezzo}</p>
              <p>Categoria: ${libro.categoria}</p>
            </li>
          `
            )
            .join("")}
        </ul>
      </div>
    </div>
  `;

  colDiv.innerHTML = cardOrdine;
  return colDiv;
}

// Call the function to fetch and display all orders
allOrders();

//////////////// delete an order

let deleteBtn = document.querySelector("#deleteButtonId");
let deleteInput = document.querySelector("#deleteInput");
let deleteResponseMessage = document.querySelector("#deleteResponseMessage");

let deleteURL = "http://localhost:9006/api/ordini/delete/";

deleteBtn.addEventListener("click", () => {
  let deleteId = parseInt(deleteInput.value.trim());

  if (!isNaN(deleteId)) {
    fetch(deleteURL + deleteId, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        if (response.ok) {
          deleteResponseMessage.innerHTML = `<p>Order with ID ${deleteId} deleted successfully.</p>`;
        } else {
          deleteResponseMessage.innerHTML = `<p>Error deleting order with ID ${deleteId}. Please try again.</p>`;
        }
      })
      .catch((error) => {
        console.error("Error deleting order:", error);
        deleteResponseMessage.innerHTML = `<p>Error deleting order with ID ${deleteId}. Please try again.</p>`;
      });
  } else {
    deleteResponseMessage.innerHTML = `<p>Please enter a valid order ID.</p>`;
  }
});
