const express = require("express");
const dotenv = require("dotenv");
const cors = require('cors')

require("dotenv").config();

const serverPort = parseInt(process.env.PORT) || 5000;

const expressApp = express();
expressApp.use(cors());
expressApp.use(express.json());
expressApp.use(express.urlencoded({ extended: false }));

dotenv.config();

expressApp.use("/posts", require("./Api/PostsApi").router);
expressApp.use("/ngos", require("./Api/NgoApi").router);
expressApp.use("/schools", require("./Api/SchoolApi").router);

expressApp.listen(serverPort, "0.0.0.0", () => console.log(`Express Server started at port ${serverPort}`));

if(process.env.debugging)
    require("./Config/Config");
else
    require("./Config/connectDB")();
