
        function trigger(){
            document.getElementById("hover").addEventListener("mouseover",popup);
        }
            function popup(){
                alert("welcome to XYZ bank!!!");
            }
        
        function validateCustomer(){
            var custId=document.getElementById("custID").value;
            var validateCust=custId.includes("XYZ");
            if(validateCust){
                document.write("customer ID is valid,you can proceed further to generate coupon");
            }
            else if(custId.trim()== ""){
                document.write("customer id cannot be blank");
            }
            else{
                document.write("you are not a valid customer");
            }
        }
        function generateCoupon(){
              var custId=document.getElementById("custID").value;
            var x=custId+"789456";
            var validateCust=custId.includes("XYZ");
            if(validateCust){
                document.write("your coupon is"+x);
            }else{
                document.write("invalid customer ID so coupon cannot be generated");
            }
        }
    