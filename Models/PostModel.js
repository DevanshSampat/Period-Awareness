const { ObjectId } = require("mongodb");
const mongoose = require("mongoose")

const postSchmea = new mongoose.Schema({
    _id : {type: ObjectId, default: () => new mongoose.Types.ObjectId()},
    question : {type: String, required: true},
    answer : {type: String},
    askedBy: {
        type: mongoose.Schema.Types.ObjectId,
        ref: "School",
    },
    answeredBy: {
        type: mongoose.Schema.Types.ObjectId,
        ref: "School",
    },
    created: {
        type: Date,
        default: Date.now()
    }
}, {
    collection: "Posts"
});

module.exports.postModel = mongoose.model("Post", postSchmea);