const { answerQuestion, getQuestion } = require("../Controllers/SchoolPostsController");

const router = new require("express").Router();

router.post("/answer", answerQuestion);
router.get("/:id", getQuestion)

module.exports.router = router;