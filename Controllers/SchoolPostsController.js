const { ObjectId } = require("mongodb");
const postModel = require("../Models/PostModel").postModel;

async function answerQuestion(req, resp)
{
    try
    {
        const {questionId, answeredById, answer} = req.body;

        const postDetails = (await postModel.find({_id: new ObjectId(questionId)}))[0];
        if(postDetails.answeredBy)
        {
            resp.status(200).json({success: false, msg: "Question already answered"});
            return;
        }

        await postModel.updateOne({_id: new ObjectId(questionId)}, {$set : {answeredBy: answeredById, answer: answer}});

        resp.status(200).json({success: true});
    }
    catch(err)
    {
        console.log(err);
        resp.sendStatus(500);
    }
}

async function getQuestion(req,resp)
{
    try
    {
        const questionId = req.params.id;

        const questionDetails = await postModel.findOne({_id: new ObjectId(questionId)},{askedBy: 0, answeredBy: 0, created: 0}).lean();
        questionDetails.questionId = questionDetails._id.toString();
        delete questionDetails._id;

        resp.status(200).json({success: true, questionDetails});
    }
    catch(err)
    {
        console.log(err);
        resp.sendStatus(500);
    }
}

module.exports = {answerQuestion, getQuestion};