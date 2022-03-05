const express = require("express");

const expressApp = express();
expressApp.use(express.json());
expressApp.use(express.urlencoded({extended: false}));

expressApp.use("/posts/school", require("./Api/SchoolPostsApi").router);

expressApp.listen(parseInt(5000), "0.0.0.0", () => console.log(`Express Server started at port ${5000}`));

require("./Config/Config");
