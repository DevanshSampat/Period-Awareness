const { registerNgo, getNgosByLocation, contactNgo, getRequests, acceptRequest} = require("../Controllers/NgoController");
const router = new require("express").Router();

router.post("/register", registerNgo);
router.get("/getngo", getNgosByLocation);
router.post("/contact", contactNgo);
router.get("/requests/:id", getRequests);
router.put("/request/accept/:id", acceptRequest);

module.exports.router = router;