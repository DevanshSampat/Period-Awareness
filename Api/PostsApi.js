const { answerQuestion, getQuestion, getSchoolQuestions, getAllQuestions, createQuestion } = require("../Controllers/PostsController");
const router = new require("express").Router();

router.post("/answer", answerQuestion);
router.get("/question/:id", getQuestion)
router.get("/getbyschool/:id", getSchoolQuestions)
router.get("/all", getAllQuestions);
router.post("/create", createQuestion);

module.exports.router = router;