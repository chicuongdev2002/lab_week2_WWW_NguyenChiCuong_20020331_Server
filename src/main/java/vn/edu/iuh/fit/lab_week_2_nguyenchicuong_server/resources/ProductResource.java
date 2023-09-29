package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Customer;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Product;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.sevices.CustomerServices;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.sevices.ProductServices;

import java.util.List;
import java.util.Optional;
@Path("/product")
public class ProductResource {
    private ProductServices productServices;
    public ProductResource(){
        productServices=new ProductServices();
    }
    @GET
    @Produces("application/json")
    public Response getALl()
    {
        List<Product> product=productServices.getAll();
        return Response.ok(productServices.getAll()).build();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id")long id){
        Optional<Product> product=productServices.findById(id);
        if(product.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else
            return Response.ok(product.get()).build();
    }
    @POST
    @Consumes("application/json")
    public Response add(Product product){
        boolean b=productServices.insert(product);
        if(b)
            return Response.status((Response.Status.CREATED)).build();
        return  Response.status((Response.Status.BAD_REQUEST)).build();
    }
    @PUT
    @Consumes("application/json")
    public Response update(Product product) {
        Optional<Boolean> update = productServices.update(product);

        if (update.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        if (update.get())
            return Response.ok().build();

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        Optional<Boolean> b = productServices.delete(id);

        if (b.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        if (b.get())
            return Response.noContent().build();

        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
