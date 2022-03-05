const { registerNgo, getNgosByLocation} = require("../Controllers/NgoController");
const router = new require("express").Router();

router.post("/register", registerNgo);
router.get("/getngo", getNgosByLocation);

module.exports.router = router;