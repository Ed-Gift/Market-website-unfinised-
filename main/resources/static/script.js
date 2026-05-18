const API = "http://localhost:8080/api";

async function register() {

    const data = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        role: document.getElementById("role").value
    };

    const response = await fetch(API + "/auth/register", {
        method: "POST",
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify(data)
    });

    const result = await response.json();

    alert("Registered Successfully");

    window.location.href = "login.html";
}

async function login() {

    const data = {
        email: document.getElementById("loginEmail").value,
        password: document.getElementById("loginPassword").value
    };

    const response = await fetch(API + "/auth/login", {
        method: "POST",
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify(data)
    });

    const token = await response.text();

    localStorage.setItem("token", token);

    alert("Login Successful");

    window.location.href = "buyer.html";
}

async function addProduct() {

    const product = {
        name: document.getElementById("productName").value,
        price: document.getElementById("productPrice").value,
        description: document.getElementById("productDescription").value
    };

    const response = await fetch(API + "/products", {
        method:"POST",
        headers:{
            "Content-Type":"application/json",
            "Authorization":"Bearer " + localStorage.getItem("token")
        },
        body:JSON.stringify(product)
    });

    alert("Product Added");
}

async function loadProducts() {

    const response = await fetch(API + "/products");

    const products = await response.json();

    let html = "";

    products.forEach(p => {

        html += `
            <div class="product">
                <h2>${p.name}</h2>
                <p>Price: R${p.price}</p>
                <p>${p.description}</p>

                <button onclick="buyProduct(${p.id})">
                    Buy
                </button>
            </div>
        `;
    });

    document.getElementById("products").innerHTML = html;
}

function buyProduct(id){

    const token = localStorage.getItem("token");

    if(!token){
        alert("Please login first");
        window.location.href = "login.html";
        return;
    }

    alert("Buying product ID: " + id);
}