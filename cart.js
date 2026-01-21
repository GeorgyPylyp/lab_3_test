import { defineStore } from "pinia";

export const useCartStore = defineStore("cart", {
  state: () => ({
    items: JSON.parse(localStorage.getItem("cartItems")) || [],
  }),

  getters: {
    totalPrice(state) {
      return state.items.reduce(
        (sum, item) => sum + item.price * item.quantity,
        0,
      );
    },

    totalQuantity(state) {
      return state.items.reduce((sum, item) => sum + item.quantity, 0);
    },

    mostPopularProduct(state) {
      if (state.items.length === 0) return null;

      return state.items.reduce((max, item) =>
        item.quantity > max.quantity ? item : max,
      );
    },
  },

  actions: {
    saveToLocalStorage() {
      localStorage.setItem("cartItems", JSON.stringify(this.items));
    },

    addToCart(product) {
      const index = this.items.findIndex((item) => item.id === product.id);

      if (index !== -1) {
        if (this.items[index].quantity < 10) {
          this.items[index] = {
            ...this.items[index],
            quantity: this.items[index].quantity + 1,
          };
        }
      } else {
        this.items.push({
          ...product,
          quantity: 1,
        });
      }

      this.saveToLocalStorage();
    },

    increaseQuantity(productId) {
      const index = this.items.findIndex((item) => item.id === productId);

      if (index !== -1 && this.items[index].quantity < 10) {
        this.items[index] = {
          ...this.items[index],
          quantity: this.items[index].quantity + 1,
        };
        this.saveToLocalStorage();
      }
    },

    decreaseQuantity(productId) {
      const index = this.items.findIndex((item) => item.id === productId);

      if (index !== -1 && this.items[index].quantity > 1) {
        this.items[index] = {
          ...this.items[index],
          quantity: this.items[index].quantity - 1,
        };
        this.saveToLocalStorage();
      }
    },

    removeFromCart(productId) {
      this.items = this.items.filter((item) => item.id !== productId);
      this.saveToLocalStorage();
    },

    clearCart() {
      this.items = [];
      this.saveToLocalStorage();
    },
  },
});
