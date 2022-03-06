const { ObjectId } = require("mongodb");
const mongoose = require("mongoose")

const schoolSchema = new mongoose.Schema({
    _id : {type: ObjectId, default: () => new mongoose.Types.ObjectId()},
    name : {type: String, required: true},
    password : {type: String, required: true},
    email: {type: String},
    phone: {type: String, default: () => Math.ceil(Math.random() * 10e10).toString()},
    students: {type: Number, default: () => Math.ceil(Math.random() * 1000)}
}, {
    collection: "Schools"
});

module.exports.schoolModel = mongoose.model("School", schoolSchema);