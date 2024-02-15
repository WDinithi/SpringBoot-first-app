getAllEmployees();
function EmployeeSave() {
    let name = ('exampleFormControlInput2').val();
    let address = ('exampleFormControlInput3').val();
    let number = ('exampleFormControlInput4').val();


    $.ajax({
        method: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/employee",
        async: true,
        data: JSON.stringify({
            "EmpId": "",
            "EmpName": name,
            "EmpAddress": address,
            "EmpMobileNumber": number
        }),
        success: function (data) {
            alert("Saved");
            getAllEmployees();
        },
        error: function (xhr, status, error) {
            alert("Error: " + error);
        }
    });
}

function EmployeeUpdate(){
    let id = ('exampleFormControlInput1').val();
    let name = ('exampleFormControlInput2').val();
    let address = ('exampleFormControlInput3').val();
    let number = ('exampleFormControlInput4').val();   $.ajax({
        method: "PUT",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/employee",
        async: true,
        data: JSON.stringify({
            "EmpId": id,
            "EmpName": name,
            "EmpAddress": address,
            "EmpMobileNumber": number
        }),
        success: function (data) {
            alert("updated");

            getAllEmployees();
        },
        error: function (xhr) {
            alert("Error");
        }
    });
}

function EmployeeDelete(){
    let id = ('exampleFormControlInput1').val();
      $.ajax({
        method: "Deleted",
        url: "http://localhost:8080/api/v1/employee"+id,
        async: true,
        success: function (data) {
            alert("Deleted");

            getAllEmployees();
        },
        error: function (xhr) {
            alert("Error");
        }
    });
}

function getAllEmployees(){
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/api/v1/employee"+id,
        async: true,
        success: function (data) {
            if (data.code=="00"){
                $(empTable).empty();
                for (let emp of data.content){
                    let empID=emp.EmpId;
                    let empName=emp.EmpName;
                    let empAddress=emp.EmpAddress;
                    let empNumber=emp.EmpMobileNumber;

                    var row=<tr> <td>${empID}</td>   <td>${empName}</td>  <td>${empAddress}</td>  <td>${empNumber}</td>  </tr>;
                    $('empTable').append(row);
                }
            }
            alert("Deleted");
        },
        error: function (xhr) {
            alert("Error");
        }
    });
}
/*function empTable() {

}*/

$(document).ready(function() {
    var col0 = $('td:eq(0)').text();    // Assuming ID is in the first <td>
    var col1 = $('td:eq(1)').text();  // Assuming Name is in the second <td>
    var col2 = $('td:eq(2)').text();  // Assuming Address is in the third <td>
    var col3 = $('td:eq(3)').text();  // Assuming Number is in the fourth <td>

    // Now you can use the variables id, name, address, and number as needed.

    $('exampleFormControlInput1').val(col0);
    $('exampleFormControlInput1').val(col1);
    $('exampleFormControlInput1').val(col2);
    $('exampleFormControlInput1').val(col3);

});
