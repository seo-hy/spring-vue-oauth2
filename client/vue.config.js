module.exports = {
  devServer: {
    overlay: false,
    port: 8080,
    proxy: {
      "^/api": {
        target: "http://127.0.0.1:8080/api",
        changeOrigin: true,
        logLevel: "debug",
      },
    },
  },
};
