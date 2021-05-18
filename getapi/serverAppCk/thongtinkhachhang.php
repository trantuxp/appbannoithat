<?php  
	include "connect.php";
	$tenkhachang=$_GET['tenkhachang'];
	$sodienthoai=$_GET['sodienthoai'];
	$email=$_GET['email'];
	if (strlen($tenkhachang)>0&&strlen($sodienthoai)>0&& strlen($email)>0 ) {
		$query="INSERT INTO donhang(id,tenuser,sodt,email) VALUES (null,'$tenkhachang','$sodienthoai','$email')";
		if (mysqli_query($connect,$query)) {
			$iddonhang= $connect ->insert_id;
			echo $iddonhang;
		}else {
			echo "Thất bại";
		}
	}else {
		echo "Bạn hãy kiểm tra lại dữ liệu";
	}
?>