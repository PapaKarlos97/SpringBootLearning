document.addEventListener('DOMContentLoaded', function () {
    const products = [
        { id: 1, name: 'Ноутбук', price: 999.99, img: 'laptop.jpg' },
        { id: 2, name: 'Смартфон', price: 499.99, img: 'smartphone.jpg' },
        { id: 3, name: 'Наушники', price: 199.99, img: 'headphones.jpg' }
    ];

    const productsContainer = document.getElementById('products');
    const cartItems = document.getElementById('cart-items');
    const cartTotal = document.getElementById('cart-total');

    let cart = [];

    function renderProducts() {
        products.forEach(product => {
            const productElement = document.createElement('div');
            productElement.classList.add('product');
            productElement.innerHTML = `
                <img src="${product.img}" alt="${product.name}">
                <h2>${product.name}</h2>
                <p>$${product.price.toFixed(2)}</p>
                <button onclick="addToCart(${product.id})">Добавить в корзину</button>
            `;
            productsContainer.appendChild(productElement);
        });
    }

    function addToCart(productId) {
        const product = products.find(p => p.id === productId);
        if (product) {
            cart.push(product);
            updateCart();
        }
    }

    function updateCart() {
        cartItems.innerHTML = '';
        let total = 0;
        cart.forEach(item => {
            const cartItem = document.createElement('li');
            cartItem.textContent = `${item.name} - $${item.price.toFixed(2)}`;
            cartItems.appendChild(cartItem);
            total += item.price;
        });
        cartTotal.textContent = total.toFixed(2);
    }

    window.addToCart = addToCart; // Make function accessible globally

    renderProducts();
});