private int uploadImage(MultipartFile file) {

        try {

            Path path = Paths.get(context.getContextPath() + "src/main/resources/static/images/"); // the path
            
           //if the directory don't exist, create it
            if (!Files.exists(path)) {   
                try {
                    Files.createDirectories(path);


                } catch (IOException e) {
                    e.printStackTrace();

                    return 0;
                }

            }

             //upload the file to the directory  ----> you can use the file original name 
             // by doing ... path.resolve(file.getOriginalName())
                // REPLACE_EXISTING replaces a file with similar name if it exist
                
            Files.copy(file.getInputStream(), path.resolve("admin.jpg"), REPLACE_EXISTING);
                
                //Files.copy(file.getInputStream(), path.resolve( file.getOriginalName() ) ); ---> this will upload all files without replacing.. exception thuough if it finds file with same name

            return 1;  // these returns are for chcking the upload status incase you call the method from somwhere else
            // 1 is pass, 0 is fail

        } catch (IOException e1) {

            e1.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return 0;
    }
