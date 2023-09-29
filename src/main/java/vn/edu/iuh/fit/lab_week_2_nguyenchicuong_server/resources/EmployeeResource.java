package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Employee;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.sevices.EmployeeService;

import java.util.List;
import java.util.Optional;

@Path("/employee")
public class EmployeeResource {
    private EmployeeService employeeService;
    public EmployeeResource(){
        employeeService=new EmployeeService();
    }
    @GET
    @Produces("application/json")
    public Response getALl()
    {
        List<Employee> employees=employeeService.getAll();
        return Response.ok(employeeService.getAll()).build();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id")long id){
        Optional<Employee> employee=employeeService.findById(id);
        if(employee.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else
            return Response.ok(employee.get()).build();
    }
    @POST
    @Consumes("application/json")
    public Response add(Employee employee){
        boolean b=employeeService.insert(employee);
        if(b)
            return Response.status((Response.Status.CREATED)).build();
        return  Response.status((Response.Status.BAD_REQUEST)).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(Employee employee) {
        Optional<Boolean> update = employeeService.update(employee);

        if (update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        if (update.get())
            return Response.ok().build();

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        // Kiểm tra xem id có tồn tại hay không
        Optional<Employee> employeeToDelete = employeeService.findById(id);

        if (employeeToDelete.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Nếu id tồn tại, thực hiện xóa
        Optional<Boolean> deleteSuccess = employeeService.delete(id);

        if (deleteSuccess.get()) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Không tìm thấy id")
                    .build();
        }
    }
}
