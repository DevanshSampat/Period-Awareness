const { ObjectId } = require("mongodb");
const mongoose = require("mongoose")

const schoolSchema = new mongoose.Schema({
    _id : {type: ObjectId, default: () => new mongoose.Types.ObjectId()},
    name : {type: String, required: true},
    password : {type: String, required: true}
}, {
    collection: "Schools"
});

module.exports.schoolModel = mongoose.model("School", schoolSchema);