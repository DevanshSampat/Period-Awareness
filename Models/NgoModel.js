const { ObjectId } = require("mongodb");
const mongoose = require("mongoose")

const ngoSchema = new mongoose.Schema({
    _id : {type: ObjectId, default: () => new mongoose.Types.ObjectId()},
    name : {type: String, required: true},
    location: {type: String, 
        enum: ["Mumbai", "Delhi", "Bangalore", "Kolkata", "Chennai"],
        default: "Mumbai"
    },
    funding: {type: Number, default: 0}
}, {
    collection: "Ngos"
});

module.exports.ngoModel = mongoose.model("Ngo", ngoSchema);