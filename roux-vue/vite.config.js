import { fileURLToPath, URL } from "node:url";

import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig({
  envDir: './environments',
  plugins: [vue()],
  resolve: {
    alias: {
      "@": '/src',
    },
  },
  server: {
    hmr: {
      clientPort: 5173
    },
    host: true,
    port: 5173,
    watch: {
      usePolling: true
    }
  }
});
