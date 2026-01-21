<template>
  <header class="bg-blue-600 text-white p-4">
    <nav class="max-w-6xl mx-auto flex justify-between">
      <h1 class="font-bold text-xl">Paint Shop</h1>
      <div class="space-x-4">
        <router-link to="/" class="hover:underline">Головна</router-link>
        <router-link to="/products" class="hover:underline">Товари</router-link>
        <router-link to="/cart" class="hover:underline">Кошик</router-link>
      </div>
    </nav>
  </header>
</template>
