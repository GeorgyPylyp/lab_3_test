<script setup>
import { useCartStore } from "../stores/cart";

const cart = useCartStore();
</script>

<template>
  <div class="max-w-6xl mx-auto p-6">
    <h1 class="text-2xl font-bold mb-6">Кошик</h1>

    <!-- Порожній кошик -->
    <p v-if="cart.items.length === 0" class="text-gray-500">Кошик порожній</p>

    <!-- Товари -->
    <div v-else>
      <div
        v-for="item in cart.items"
        :key="item.id"
        class="flex justify-between items-center border-b py-4"
      >
        <div>
          <h2 class="font-semibold">{{ item.name }}</h2>
          <p>{{ item.price }} грн</p>
        </div>

        <!-- Кількість -->
        <div class="flex items-center gap-3">
          <button
            class="px-3 py-1 border rounded"
            @click="cart.decreaseQuantity(item.id)"
          >
            −
          </button>

          <span class="font-semibold">{{ item.quantity }}</span>

          <button
            class="px-3 py-1 border rounded"
            @click="cart.increaseQuantity(item.id)"
          >
            +
          </button>
        </div>

        <!-- Видалити -->
        <button
          class="text-red-500 hover:underline"
          @click="cart.removeFromCart(item.id)"
        >
          Видалити
        </button>
      </div>

      <!-- Сума -->
      <p class="mt-6 font-bold text-lg">Сума: {{ cart.totalPrice }} грн</p>

      <!-- Найпопулярніший товар -->
      <p v-if="cart.mostPopularProduct" class="mt-2 text-sm text-gray-600">
        Найпопулярніший товар:
        <strong>{{ cart.mostPopularProduct.name }}</strong>
      </p>

      <!-- Кнопки -->
      <div class="mt-6 flex gap-4">
        <button class="bg-gray-200 px-4 py-2 rounded" @click="cart.clearCart()">
          Очистити кошик
        </button>

        <button
          class="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700"
          @click="alert('Оформлення замовлення в розробці')"
        >
          Оформити замовлення
        </button>
      </div>
    </div>
  </div>
</template>
