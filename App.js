const express = require("express");
const connectDB = require("./config/connectDB");
const dotenv = require("dotenv");

const expressApp = express();
expressApp.use(express.json());
expressApp.use(express.urlencoded({ extended: false }));

dotenv.config();
connectDB();

expressApp.listen(parseInt(5000), "0.0.0.0", () => console.log(`Express Server started at port ${5000}`));
