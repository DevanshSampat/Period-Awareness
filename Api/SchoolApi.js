const { registerSchool, authenticateSchool, getAllSchools } = require("../Controllers/SchoolController");
const router = new require("express").Router();
const schoolModel = require("../Models/SchoolModel").schoolModel;

router.post("/register", registerSchool);
router.post("/auth", authenticateSchool);
router.get("/all", getAllSchools);
router.get("/gen", async (req,resp) => {
    const dummySchools = [
        {
            name: "Shahaji Raje Bmc School",
            location: "Mumbai",
            email: "srbmcs@gmail.com",
            phone: "9999999999",
            noOfStudents: 500
        },
        {
            name: "Rajkiya Pratibha Vikas Vidyalayas",
            location: "Delhi",
            email: "rpvv@gmail.com",
            phone: "8888888888",
            noOfStudents: 300
        },
        {
            name: "Jawahar Navodaya Vidyalayas",
            location: "Mumbai",
            email: "jnvmumbai@gmail.com",
            phone: "9999988888",
            noOfStudents: 200
        },
        {
            name: "Sainik School",
            location: "Pune",
            email: "sainikspune@gmail.com",
            phone: "9777777777",
            noOfStudents: 300
        },
        {
            name: "Navyug School",
            location: "Delhi",
            email: "navug@gmail.com",
            phone: "9999999999",
            noOfStudents: 500
        },
        {
            name: "Jadavpur Vidyapith",
            location: "West Bengal",
            email: "jvwb@gmail.com",
            phone: "9888888888",
            noOfStudents: 500
        },
        {
            name: "Oak Grove School",
            location: "Uttarakhand",
            email: "ogsut@gmail.com",
            phone: "6666666666",
            noOfStudents: 200
        },
        {
            name: "GVHSS for Girls, Nadakkavu",
            location: "Kerala",
            email: "gvhss@gmail.com",
            phone: "8888888888",
            noOfStudents: 500
        },
        {
            name: "Sarvodaya Vidyalayas",
            location: "Delhi",
            email: "svdelhi@gmail.com",
            phone: "9966996699",
            noOfStudents: 500
        }    
    ];

    for(let i = 0; i < dummySchools.length; ++i)
    {
        const school = dummySchools[i];
        await (new schoolModel({
            name : school.name,
            password : "pss123456",
            email : `${school.name.replace(/\s/g, "")}@email.com`
        })).save()
    }

    resp.sendStatus(200);
})

module.exports.router = router;