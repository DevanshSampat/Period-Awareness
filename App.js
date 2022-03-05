const express = require("express");
const connectDB = require("./config/connectDB");
const dotenv = require("dotenv");

require("dotenv").config();

const serverPort = parseInt(process.env.PORT) || 5000;

const expressApp = express();
expressApp.use(express.json());
expressApp.use(express.urlencoded({ extended: false }));

dotenv.config();
connectDB();

expressApp.use("/posts/school", require("./Api/SchoolPostsApi").router);
expressApp.use("/ngos", require("./Api/NgoApi").router);

expressApp.listen(serverPort, "0.0.0.0", () => console.log(`Express Server started at port ${serverPort}`));

if(process.env.debugging)
    require("./Config/Config");
