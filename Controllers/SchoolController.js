const schoolModel = require("../Models/SchoolModel").schoolModel;

async function registerSchool(req,resp)
{
    try
    {
        const {schoolName, password} = req.body;

        if((await schoolModel.exists({name:schoolName})))
        {
            resp.status(200).json({success:false,msg:"School already registered"});
            return;
        }

        const schoolId = (await (new schoolModel({
            name : schoolName,
            password
        })).save())._id.toString();

        resp.status(200).json({success:true,schoolId});
    }
    catch(err)
    {
        console.log(err);
        resp.sendStatus(500);
    }
}

async function authenticateSchool(req,resp)
{
    try
    {
       const {schoolName, password} = req.body;

       const schoolDetails = await schoolModel.findOne({name:schoolName});
       if(!schoolDetails)
       {
            resp.status(200).json({success:false,msg:"School not registered"});
            return;
       }

       if(schoolDetails.password !== password)
        {
            resp.status(200).json({success:false,msg:"Incorrect Password"});
            return;
        }

        resp.status(200).json({success: true, id: schoolDetails._id.toString()});
    }
    catch(err)
    {
        console.log(err);
        resp.sendStatus(500);
    }
}

async function getAllSchools(req,resp)
{
    try
    {
        const schools = await schoolModel.find({}, {password:0, __v : 0});

        resp.status(200).json({success: true, schools});
    }
    catch(err)
    {
        console.log(err);
        resp.sendStatus(500);
    }
}

module.exports = {registerSchool, authenticateSchool, getAllSchools};