<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="regCustomer" method="post">
		<label for="tbName">Name:</label><input type="text" name="tbName" id="tbName" />
		
		<br>
		
		<label for="tbMobile">Mobile:</label><input type="tel" name="tbMobile" id="tbMobile" />
		
		<br>
		
		<label for="tbGender"> Gender: </label><input type="radio" name="tbGender" id="tbGender" value="Male" />Male
							  <input type="radio" name="tbGender" id="tbGender" value="Female"/>Female
		                      <input type="radio" name="tbGender" id="tbGender" value="Others"/>Others
		                 
		<br>                      
		<label for="ddlQual">Qualification:</label><select name="ddlQual" id="ddlQual">
		                             <option>-----select-----</option>
		                             <option value="B.Tech">B.Tech</option>
		                             <option value="M.Tech">M.Tech</option>
		                             <option value="BCA">BCA</option>
		                             <option value="MCA">MCA</option>
		                             <option value="B.Com">B.Com</option>
		                             <option value="M.Com">M.Com</option>
		                             <option value="B.Sc">B.Sc</option>
		                             <option value="M.Sc">M.SC</option>
		                             <option value="B.Pharm">B.Pharm</option>
		                             <option value="M.Pharm">M.Pharm</option>
		                             <option value="BBA">BBA</option>
		                             <option value="MBA">MBA</option>
		                             <option value="B.Arch">B.Arch</option>
		                             <option value="M.Arch">M.Arch</option>
		                             <option value="BA">BA</option>
		                             <option value="MA">MA</option>
									</select>
									
	<br>
	<label for="ddlState">State:</label><select name="ddlState" id="ddlState">
		                     <option>-----select-----</option>
		                     <option value="Assam">Assam</option>
		                     <option value="Bihar">Bihar</option>
		                     <option value="Karnataka">Karnatak</option>
		                     <option value="TamilNadu">Tamil Nadu</option>
		                     <option value="AndhraPradesh">Andhra Pradesh</option>
		                     <option value="Odisha">Odisha</option>
		                     <option value="WestBengal">West Bengal</option>
		                     <option value="Rajasthan">Rajasthan</option>
		                     <option value="Haryana">Haryana</option>
		                     <option value="Punjab">Punjab</option>
		                     <option value="HP">HP</option>
		                     <option value="UP">UP</option>
		                     <option value="Maharastra">Maharastra</option>
		                     <option value="Gujrat">Gujrat</option>
		                     <option value="Kerala">Kerala</option>
		                     <option value="Goa">Goa</option>
		                     <option value="Others">Others</option>
						</select>							
		<br>
		<label for="tbEmail">Email:</label><input type="email" name="tbEmail" id="tbEmail" />
		
		<br>
		<label for="tbPass">Password:</label><input type="password" name="tbPass" id="tbPass" />
		<br>
		<input type="submit" value="Register" />						
		
	</form>


</body>
</html>