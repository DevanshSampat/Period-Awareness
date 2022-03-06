const { ObjectId } = require("mongodb");
const mongoose = require("mongoose")

const ngoSchoolMapSchema = new mongoose.Schema({
    _id : {type: ObjectId, default: new mongoose.Types.ObjectId()},
    schoolId: {type: ObjectId, required: true},
    ngoId: {type: ObjectId, required: true},
    contactDate : {type: Date, default: () => Date.now()},
    status: {type: String, enum: ["Pending", "Completed"], default : "Pending"},
    budget : {type: Number, default: 0}
},{
    collection: "NgoSchoolMapping"
});

module.exports.ngoSchoolMapModel = mongoose.model("NgoSchoolMap", ngoSchoolMapSchema);