const ngoModel = require("../Models/NgoModel").ngoModel;

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

module.exports = {registerNgo, getNgosByLocation};