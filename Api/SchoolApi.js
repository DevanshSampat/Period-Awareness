const { registerSchool, authenticateSchool, getAllSchools } = require("../Controllers/SchoolController");
const router = new require("express").Router();

router.post("/register", registerSchool);
router.post("/auth", authenticateSchool);
router.get("/all", getAllSchools);

module.exports.router = router;