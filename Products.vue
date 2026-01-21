<script setup>
import { ref, computed } from "vue";
import { useCartStore } from "../stores/cart";

const cart = useCartStore();

const selectedCategory = ref("all");

const searchQuery = ref("");
const sortOption = ref("");

const products = ref([
  {
    id: 1,
    name: "Акрилова фарба",
    description: "Для внутрішніх робіт",
    price: 300,
    category: "interior",
    image: "https://via.placeholder.com/300x200",
  },
  {
    id: 2,
    name: "Фасадна фарба",
    description: "Стійка до погодних умов",
    price: 420,
    category: "exterior",
    image: "https://via.placeholder.com/300x200",
  },
  {
    id: 3,
    name: "Емаль",
    description: "Для металу та дерева",
    price: 350,
    category: "enamel",
    image: "https://via.placeholder.com/300x200",
  },
]);

const filteredProducts = computed(() => {
  if (selectedCategory.value === "all") {
    return products.value;
  }
  return products.value.filter(
    (product) => product.category === selectedCategory.value,
  );
});

const filteredAndSortedProducts = computed(() => {
  let result = products.value;

  // фільтр по категорії
  if (selectedCategory.value !== "all") {
    result = result.filter((p) => p.category === selectedCategory.value);
  }

  // пошук
  if (searchQuery.value) {
    result = result.filter((p) =>
      p.name.toLowerCase().includes(searchQuery.value.toLowerCase()),
    );
  }

  // сортування
  if (sortOption.value === "price-asc") {
    result = [...result].sort((a, b) => a.price - b.price);
  }

  if (sortOption.value === "price-desc") {
    result = [...result].sort((a, b) => b.price - a.price);
  }

  return result;
});
</script>

<template>
  <div class="max-w-6xl mx-auto p-6">
    <h1 class="text-2xl font-bold mb-6">Фарби</h1>

    <input
      v-model="searchQuery"
      type="text"
      placeholder="Пошук фарби..."
      class="border px-4 py-2 rounded w-full max-w-md my-1.5"
    />

    <select v-model="sortOption" class="border px-4 py-2 rounded mx-1.5">
      <option value="">Без сортування</option>
      <option value="price-asc">Ціна ↑</option>
      <option value="price-desc">Ціна ↓</option>
    </select>

    <!-- Категорії -->
    <div class="flex gap-4 mb-6">
      <button
        class="px-4 py-2 rounded border"
        :class="selectedCategory === 'all' ? 'bg-blue-600 text-white' : ''"
        @click="selectedCategory = 'all'"
      >
        Усі
      </button>
      <button
        class="px-4 py-2 rounded border"
        :class="selectedCategory === 'interior' ? 'bg-blue-600 text-white' : ''"
        @click="selectedCategory = 'interior'"
      >
        Для дому
      </button>
      <button
        class="px-4 py-2 rounded border"
        :class="selectedCategory === 'exterior' ? 'bg-blue-600 text-white' : ''"
        @click="selectedCategory = 'exterior'"
      >
        Фасадні
      </button>
      <button
        class="px-4 py-2 rounded border"
        :class="selectedCategory === 'enamel' ? 'bg-blue-600 text-white' : ''"
        @click="selectedCategory = 'enamel'"
      >
        Емалі
      </button>
    </div>

    <!-- Товари -->
    <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
      <div
        v-for="product in filteredAndSortedProducts"
        :key="product.id"
        class="border rounded-xl p-4 hover:shadow-lg transition"
      >
        <img
          :src="product.image"
          alt=""
          class="h-40 w-full object-cover rounded mb-3"
        />

        <h2 class="font-semibold text-lg">{{ product.name }}</h2>
        <p class="text-sm text-gray-600">{{ product.description }}</p>
        <p class="font-bold mt-2">{{ product.price }} грн</p>

        <button
          class="mt-4 w-full bg-blue-600 hover:bg-blue-700 text-white py-2 rounded"
          @click="cart.addToCart(product)"
        >
          Додати в кошик
        </button>
      </div>
    </div>
  </div>
</template>
