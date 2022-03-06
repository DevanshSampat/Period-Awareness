const { registerNgo, getNgosByLocation, contactNgo, getRequests} = require("../Controllers/NgoController");
const router = new require("express").Router();

router.post("/register", registerNgo);
router.get("/getngo", getNgosByLocation);
router.post("/contact", contactNgo);
router.get("/requests/:id", getRequests);

module.exports.router = router;