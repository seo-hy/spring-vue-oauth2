const path = require("path");

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
  chainWebpack: (config) => {
    config.resolve.alias.set("@", path.resolve(__dirname, "src/"));
  },
};
