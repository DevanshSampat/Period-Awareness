const ngoModel = require("../Models/NgoModel").ngoModel;
const ngoMapModel = require("../Models/NgoSchoolMap").ngoSchoolMapModel;

async function registerNgo(req,resp)
{
    try
    {
        const ngo = new ngoModel({
            name: req.body.name,
            location: req.body.loc,
            funding: req.body.funding
        });

        await ngo.save();

        return resp.sendStatus(200);
    }
    catch(err)
    {
        console.log(err);
        resp.sendStatus(500);
    }
}

async function getNgosByLocation(req,resp)
{
    try
    {
        const loc = req.query.loc;

        const ngos = await ngoModel.find({location: loc},{name: 1, location: 1});

        resp.status(200).json({success: true, ngos});
    }
    catch(err)
    {
        console.log(err);
        resp.sendStatus(500);
    }
}

async function contactNgo(req,resp)
{
    try
    {
        const {ngoId, schoolId} = req.body;

        let request = await ngoMapModel.findOne({ngoId:ngoId, schoolId:schoolId},{contactDate:1, status:1, _id:0});
        if(request)
        {
            resp.status(200).json({success:false, msg: "Already contact request sent", requestDetails:request});
            return;
        }

        request = new ngoMapModel({
            schoolId,
            ngoId,
        });
        await request.save();

        resp.sendStatus(200);
    }
    catch(err)
    {
        console.log(err);
        resp.sendStatus(500);
    }
}

async function getRequests(req,resp)
{
    try
    {
        const ngoId = req.params.id;

        const mappings = await ngoMapModel.find({ngoId},{ngoId:0}).lean();
        const requests = {pending : [], completed: []};
        mappings.forEach((mapping) => {
            if(mapping.status === "Pending")
                requests.pending.push(mapping);
            else
                requests.completed.push(mapping);
        });

        resp.status(200).json({success: true, requests});
    }
    catch(err)
    {
        console.log(err);
        resp.sendStatus(500);
    }
}


module.exports = {registerNgo, getNgosByLocation, contactNgo, getRequests};