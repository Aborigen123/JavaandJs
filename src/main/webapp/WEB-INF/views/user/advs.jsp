<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<ul>
	<c:forEach items="${carList}" var="car">
		<li>
			<img alt="car" src="data:image/png;base64, ${car.carImage}" width="300px">
			| ${car.make} | ${car.model } | ${car.user.firstName}
		</li>
	</c:forEach>
</ul>