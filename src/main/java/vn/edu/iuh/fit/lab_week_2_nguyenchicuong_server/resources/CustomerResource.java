package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Customer;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Employee;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.sevices.CustomerServices;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.sevices.EmployeeService;

import java.util.List;
import java.util.Optional;
@Path("/customer")
public class CustomerResource {
    private CustomerServices customerServices;
    public CustomerResource(){
        customerServices=new CustomerServices();
    }
    @GET
    @Produces("application/json")
    public Response getALl()
    {
        List<Customer> employees=customerServices.getAll();
        return Response.ok(customerServices.getAll()).build();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id")long id){
        Optional<Customer> customer=customerServices.findById(id);
        if(customer.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else
            return Response.ok(customer.get()).build();
    }
    @POST
    @Consumes("application/json")
    public Response add(Customer customer){
        boolean b=customerServices.insert(customer);
        if(b)
            return Response.status((Response.Status.CREATED)).build();
        return  Response.status((Response.Status.BAD_REQUEST)).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(Customer customer) {
        Optional<Boolean> update = customerServices.update(customer);

        if (update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        if (update.get())
            return Response.ok().build();

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        Optional<Boolean> b = customerServices.delete(id);

        if (b.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        if (b.get())
            return Response.noContent().build();

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
