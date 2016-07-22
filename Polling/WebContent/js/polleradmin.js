$disableelement=-1;
$disabletype="";
$globalpollid=-1;

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();
	
	$('body').on('click','.pageno',function(){
		
		$id=$(this).attr('id');
		 $(this).parent().siblings('li').removeClass('active');
	     $(this).parent().addClass('active');
		
		$('.polltable').children().each(function(i){
			
			if(Math.ceil((i+1)/10)==$id)
				{
				$(this).css("display","");
				}
			else
				$(this).css("display","none");

		})
	
	})
	
	
	$('#ageselect').on('change', function() {
 
		$.post('AdvancedStatsController', {pollID:$globalpollid,age:$(this).val(),actionType:"age"}, function(responseJSON) {
		
			$("#agedistchart").remove();
			 $("#agedistchartdiv").append('<canvas id="agedistchart" width="400" height="400"></canvas>');
			 
			 
			 var ctx = document.getElementById("agedistchart");
			 var total=responseJSON.agevotes[0]+responseJSON.agevotes[1]+responseJSON.agevotes[2]+responseJSON.agevotes[3];
			 window.myAnswerChart = new Chart(ctx, {
			     type: 'bar',
			     data: {
			         labels: ["A("+responseJSON.agevotes[0]+")","B("+responseJSON.agevotes[1]+")","C("+responseJSON.agevotes[2]+")","D("+responseJSON.agevotes[3]+")"],
			         datasets: [{
			             label: '% of Votes',
			             backgroundColor: "#51D071",
			             borderColor: "#003E28",
			             borderWidth: 1,
			             hoverBackgroundColor: "#118F62",
			             hoverBorderColor: "#003E28",
			             data:[Math.round(responseJSON.agevotes[0]/total*100),Math.round(responseJSON.agevotes[1]/total*100),Math.round(responseJSON.agevotes[2]/total*100),Math.round(responseJSON.agevotes[3]/total*100)]
			         }]
			     },
			     options: {
			         scales: {
			             yAxes: [{
			                 ticks: {
			                     beginAtZero:true
			                 }
			             }]
			         }
			     }
			 }).update();
			
		
		});
    });
	
	
	
	
	
	$('#areaselect').on('change', function() {
		 
		$.post('AdvancedStatsController', {pollID:$globalpollid,area:$(this).val(),actionType:"area"}, function(responseJSON) {
		
			$("#areadistchart").remove();
			 $("#areadistchartdiv").append('<canvas id="areadistchart" width="400" height="400"></canvas>');
			 
			 
			 var ctx = document.getElementById("areadistchart");
			 var total=responseJSON.areavotes[0]+responseJSON.areavotes[1]+responseJSON.areavotes[2]+responseJSON.areavotes[3];
			 window.myAnswerChart = new Chart(ctx, {
			     type: 'bar',
			     data: {
			         labels: ["A("+responseJSON.areavotes[0]+")","B("+responseJSON.areavotes[1]+")","C("+responseJSON.areavotes[2]+")","D("+responseJSON.areavotes[3]+")"],
			         datasets: [{
			             label: '% of Votes',
			             backgroundColor: "#51D071",
			             borderColor: "#003E28",
			             borderWidth: 1,
			             hoverBackgroundColor: "#118F62",
			             hoverBorderColor: "#003E28",
			             data:[Math.round(responseJSON.areavotes[0]/total*100),Math.round(responseJSON.areavotes[1]/total*100),Math.round(responseJSON.areavotes[2]/total*100),Math.round(responseJSON.areavotes[3]/total*100)]
			         }]
			     },
			     options: {
			         scales: {
			             yAxes: [{
			                 ticks: {
			                     beginAtZero:true
			                 }
			             }]
			         }
			     }
			 }).update();
			
		
		});
    })
	
	
	
    
    
    
    
    $('#univselect').on('change', function() {
		 
		$.post('AdvancedStatsController', {pollID:$globalpollid,univ:$(this).val(),actionType:"univ"}, function(responseJSON) {
		
			$("#univdistchart").remove();
			 $("#univdistchartdiv").append('<canvas id="univdistchart" width="400" height="400"></canvas>');
			 
			 
			 var ctx = document.getElementById("univdistchart");
			 var total=responseJSON.univvotes[0]+responseJSON.univvotes[1]+responseJSON.univvotes[2]+responseJSON.univvotes[3];
			 window.myAnswerChart = new Chart(ctx, {
			     type: 'bar',
			     data: {
			         labels: ["A("+responseJSON.univvotes[0]+")","B("+responseJSON.univvotes[1]+")","C("+responseJSON.univvotes[2]+")","D("+responseJSON.univvotes[3]+")"],
			         datasets: [{
			             label: '% of Votes',
			             backgroundColor: "#51D071",
			             borderColor: "#003E28",
			             borderWidth: 1,
			             hoverBackgroundColor: "#118F62",
			             hoverBorderColor: "#003E28",
			             data:[Math.round(responseJSON.univvotes[0]/total*100),Math.round(responseJSON.univvotes[1]/total*100),Math.round(responseJSON.univvotes[2]/total*100),Math.round(responseJSON.univvotes[3]/total*100)]
			         }]
			     },
			     options: {
			         scales: {
			             yAxes: [{
			                 ticks: {
			                     beginAtZero:true
			                 }
			             }]
			         }
			     }
			 }).update();
			
		
		});
    })
	
	
    
        $('#generate').on('click', function() {
		 
		$.post('AdvancedStatsController', {pollID:$globalpollid,univ:$('#univcombselect').val(),actionType:"combinational",area:$('#areacombselect').val(),age:$('#agecombselect').val(),gender:$('#gendercombselect').val()}, function(responseJSON) {
		
			$("#combdistchart").remove();
			 $("#combdistchartdiv").append('<canvas id="combdistchart" width="400" height="400"></canvas>');
			 
			 
			 var ctx = document.getElementById("combdistchart");
			 var total=responseJSON.combvotes[0]+responseJSON.combvotes[1]+responseJSON.combvotes[2]+responseJSON.combvotes[3];
			 window.myAnswerChart = new Chart(ctx, {
			     type: 'bar',
			     data: {
			         labels: ["A("+responseJSON.combvotes[0]+")","B("+responseJSON.combvotes[1]+")","C("+responseJSON.combvotes[2]+")","D("+responseJSON.combvotes[3]+")"],
			         datasets: [{
			             label: '% of Votes',
			             backgroundColor: "#51D071",
			             borderColor: "#003E28",
			             borderWidth: 1,
			             hoverBackgroundColor: "#118F62",
			             hoverBorderColor: "#003E28",
			             data:[Math.round(responseJSON.combvotes[0]/total*100),Math.round(responseJSON.combvotes[1]/total*100),Math.round(responseJSON.combvotes[2]/total*100),Math.round(responseJSON.combvotes[3]/total*100)]
			         }]
			     },
			     options: {
			         scales: {
			             yAxes: [{
			                 ticks: {
			                     beginAtZero:true
			                 }
			             }]
			         }
			     }
			 }).update();
			
		
		});
    })
    
    
	
	
	
	
	$('body').on('click','.adminpollelement',function(){
		 $('#schooltable').empty();
		 $('#areatable').empty();
		 $('#agetable').empty();
		$("#univcombselect").val('-2');
		
		
		
		
		$('#agedistchart').remove();
		$('#areadistchart').remove();
		$('#univdistchart').remove();
		$('#combdistchart').remove();
		
		
		
		$pollid=$(this).attr('id');
		$('#pollid_edit').val($pollid);
		$globalpollid=$pollid;
		 $.post('PollStatsController', {poll_id:$pollid}, function(responseJSON) {
	      var tempa=0;
	      var tempb=0;
	      var tempc=0;
	      var tempd=0;
	      var tempt=0;
	      
			 
			 for(var i=0;i<responseJSON.AgeTable.length;i++)
			 {
				 
				 tempa=tempa+responseJSON.AgeTable[i].A;	
				 tempb=tempb+responseJSON.AgeTable[i].B;
				 tempc=tempc+responseJSON.AgeTable[i].C;
				 tempd=tempd+responseJSON.AgeTable[i].D;
				 tempt=tempt+responseJSON.AgeTable[i].A+responseJSON.AgeTable[i].B+responseJSON.AgeTable[i].C+responseJSON.AgeTable[i].D;
				 
		var temptr ="<tr>"
		temptr = temptr.concat("<td>"+responseJSON.AgeTable[i].name+"</td>");
		
		temptr = temptr.concat("<td>"+responseJSON.AgeTable[i].A+"</td>");
		
		temptr = temptr.concat("<td>"+responseJSON.AgeTable[i].B+"</td>");
		
		temptr = temptr.concat("<td>"+responseJSON.AgeTable[i].C+"</td>");
		
		temptr = temptr.concat("<td>"+responseJSON.AgeTable[i].D+"</td>");
		temptr = temptr.concat("<td>"+(responseJSON.AgeTable[i].A+responseJSON.AgeTable[i].B+responseJSON.AgeTable[i].C+responseJSON.AgeTable[i].D)+"</td>");
		temptr = temptr.concat("</tr>");
		 $('#agetable').append(temptr);
			 } 
			 var temptr ="<tr>"
					temptr = temptr.concat("<td>Total</td>");
					
					temptr = temptr.concat("<td>"+tempa+"</td>");
					
					temptr = temptr.concat("<td>"+tempb+"</td>");
					
					temptr = temptr.concat("<td>"+tempc+"</td>");
					
					temptr = temptr.concat("<td>"+tempd+"</td>");
					temptr = temptr.concat("<td>"+tempt+"</td>");
					temptr = temptr.concat("</tr>");
					 $('#agetable').append(temptr);
			 
			 
			 tempa=0;
			 tempb=0;
			 tempc=0;
			 tempd=0;
			 tempt=0;
			 
			 
			 
			 
			 
			 
			 
			 for(var i=0;i<responseJSON.SchoolTable.length;i++)
				 {
				 
				 tempa=tempa+responseJSON.SchoolTable[i].A;	
				 tempb=tempb+responseJSON.SchoolTable[i].B;
				 tempc=tempc+responseJSON.SchoolTable[i].C;
				 tempd=tempd+responseJSON.SchoolTable[i].D;
				 tempt=tempt+responseJSON.SchoolTable[i].A+responseJSON.SchoolTable[i].B+responseJSON.SchoolTable[i].C+responseJSON.SchoolTable[i].D;
				 
				 
				 
			var temptr ="<tr>"
			temptr = temptr.concat("<td>"+responseJSON.SchoolTable[i].name+"</td>");
			temptr = temptr.concat("<td>"+responseJSON.SchoolTable[i].A+"</td>");
			temptr = temptr.concat("<td>"+responseJSON.SchoolTable[i].B+"</td>");
			temptr = temptr.concat("<td>"+responseJSON.SchoolTable[i].C+"</td>");
			temptr = temptr.concat("<td>"+responseJSON.SchoolTable[i].D+"</td>");
			temptr = temptr.concat("<td>"+(responseJSON.SchoolTable[i].A+responseJSON.SchoolTable[i].B+responseJSON.SchoolTable[i].C+responseJSON.SchoolTable[i].D)+"</td>");
			temptr = temptr.concat("</tr>");
			 $('#schooltable').append(temptr);
				 } 
			 
			 var temptr ="<tr>"
					temptr = temptr.concat("<td>Total</td>");
					
					temptr = temptr.concat("<td>"+tempa+"</td>");
					
					temptr = temptr.concat("<td>"+tempb+"</td>");
					
					temptr = temptr.concat("<td>"+tempc+"</td>");
					
					temptr = temptr.concat("<td>"+tempd+"</td>");
					temptr = temptr.concat("<td>"+tempt+"</td>");
					temptr = temptr.concat("</tr>");
					 $('#schooltable').append(temptr);
			 
			 
			 
			 
					 tempa=0;
					 tempb=0;
					 tempc=0;
					 tempd=0;
					 tempt=0;
			 
			 
			 
			 for(var i=0;i<responseJSON.AreaTable.length;i++)
			 {
				 tempa=tempa+responseJSON.AreaTable[i].A;	
				 tempb=tempb+responseJSON.AreaTable[i].B;
				 tempc=tempc+responseJSON.AreaTable[i].C;
				 tempd=tempd+responseJSON.AreaTable[i].D;
				 tempt=tempt+responseJSON.AreaTable[i].A+responseJSON.AreaTable[i].B+responseJSON.AreaTable[i].C+responseJSON.AreaTable[i].D;
				 
				 
				 
		var temptr ="<tr>"
		temptr = temptr.concat("<td>"+responseJSON.AreaTable[i].name+"</td>");
		temptr = temptr.concat("<td>"+responseJSON.AreaTable[i].A+"</td>");
		temptr = temptr.concat("<td>"+responseJSON.AreaTable[i].B+"</td>");
		temptr = temptr.concat("<td>"+responseJSON.AreaTable[i].C+"</td>");
		temptr = temptr.concat("<td>"+responseJSON.AreaTable[i].D+"</td>");
		temptr = temptr.concat("<td>"+(responseJSON.AreaTable[i].A+responseJSON.AreaTable[i].B+responseJSON.AreaTable[i].C+responseJSON.AreaTable[i].D)+"</td>");
		temptr = temptr.concat("</tr>");
		 $('#areatable').append(temptr);
			 } 
		 
			 var temptr ="<tr>"
					temptr = temptr.concat("<td>Total</td>");
					
					temptr = temptr.concat("<td>"+tempa+"</td>");
					
					temptr = temptr.concat("<td>"+tempb+"</td>");
					
					temptr = temptr.concat("<td>"+tempc+"</td>");
					
					temptr = temptr.concat("<td>"+tempd+"</td>");
					temptr = temptr.concat("<td>"+tempt+"</td>");
					temptr = temptr.concat("</tr>");
					 $('#areatable').append(temptr);
			 
			 
		 $('#votes').text(responseJSON.votes);
		 $('#option').text(responseJSON.option);
		 
		 $("#genderchart").remove();
		 $("#genderchartdiv").append('<canvas id="genderchart" width="400" height="400"></canvas>');
		 
		 var ctx = document.getElementById("genderchart");
		 var genderdata= {
				    labels: [
				             "Male",
				             "Female"
				         ],
				         datasets: [
				             {
				                 data: [responseJSON.genderlist[0],responseJSON.genderlist[1]],
				                 backgroundColor: [
				                     "#36A2EB",
				                     "#FF6384"
				                     
				                 ],
				                 hoverBackgroundColor: [
				                     "#2D5A79",
				                     "#82293C"
				                     
				                 ]
				             }]
				     };
		 
		 window.myGenderChart = new Chart(ctx,{
			    data: genderdata,
			    type: "doughnut",
			    options: {
			    }
			});
		 
		 
		 $("#agechart").remove();
		 $("#agechartdiv").append('<canvas id="agechart" width="400" height="400"></canvas>');
		 
		 
		 
		 
		 var ctx = document.getElementById("agechart");
		 var agedata= {
				    labels: responseJSON.ageobject.age,
				    datasets: [
				        {
				            label: "Age Count",
				            fill: false,
				            lineTension: 0.1,
				            backgroundColor: "rgba(75,192,192,0.4)",
				            borderColor: "rgba(75,192,192,1)",
				            borderCapStyle: 'butt',
				            borderDash: [],
				            borderDashOffset: 0.0,
				            borderJoinStyle: 'miter',
				            pointBorderColor: "rgba(75,192,192,1)",
				            pointBackgroundColor: "#fff",
				            pointBorderWidth: 1,
				            pointHoverRadius: 5,
				            pointHoverBackgroundColor: "rgba(75,192,192,1)",
				            pointHoverBorderColor: "rgba(220,220,220,1)",
				            pointHoverBorderWidth: 2,
				            pointRadius: 1,
				            pointHitRadius: 10,
				            data: responseJSON.ageobject.agecount,
				        }
				    ]
				};
		 window.myAgeChart = new Chart(ctx,{
			    data: agedata,
			    type: "line",
			    options: {
			    }
			});
		 
		 
		 
		 
		 
		 $('#infotitle').html("Title : "+responseJSON.title);
		 $('#infodesc').html("Description : "+responseJSON.description);
		 $('#infoa').html("Option A : "+responseJSON.optionOne);
		 $('#infob').html("Option B : "+responseJSON.optionTwo);
		 $('#infoc').html("Option C : "+responseJSON.optionThree);
		 $('#infod').html("Option D : "+responseJSON.optionFour);
		 
		 
		 $("#answerchart").remove();
		 $("#answerchartdiv").append('<canvas id="answerchart" width="400" height="400"></canvas>');
		 
		 
		 var ctx = document.getElementById("answerchart");
		 var total4=responseJSON.answerslist[0]+responseJSON.answerslist[1]+responseJSON.answerslist[2]+responseJSON.answerslist[3];
		 window.myAnswerChart = new Chart(ctx, {
		     type: 'bar',
		     data: {
		         labels: ["A("+responseJSON.answerslist[0]+")","B("+responseJSON.answerslist[1]+")","C("+responseJSON.answerslist[2]+")","D("+responseJSON.answerslist[3]+")"],
		         datasets: [{
		             label: '% of Votes',
		             backgroundColor: "#51D071",
		             borderColor: "#003E28",
		             borderWidth: 1,
		             hoverBackgroundColor: "#118F62",
		             hoverBorderColor: "#003E28",
		             data: [Math.round(responseJSON.answerslist[0]/total4*100),Math.round(responseJSON.answerslist[1]/total4*100),Math.round(responseJSON.answerslist[2]/total4*100),Math.round(responseJSON.answerslist[3]/total4*100)]
		         }]
		     },
		     options: {
		         scales: {
		             yAxes: [{
		                 ticks: {
		                     beginAtZero:true
		                 }
		             }]
		         }
		     }
		 }).update();
		 
		 
		 

		 $("#areachart").remove();
		 $("#areachartdiv").append('<canvas id="areachart" width="400" height="400"></canvas>');
		 
		 
		 
		 
		 var ctx = document.getElementById("areachart");
		 var areadata= {
				    labels: responseJSON.area.arealist,
				    datasets: [
				        {
				        	label: "Count",
				            fill: false,
				            lineTension: 0.1,
				            backgroundColor: "rgba(75,192,192,0.4)",
				            borderColor: "rgba(75,192,192,1)",
				            borderCapStyle: 'butt',
				            borderDash: [],
				            borderDashOffset: 0.0,
				            borderJoinStyle: 'miter',
				            pointBorderColor: "rgba(75,192,192,1)",
				            pointBackgroundColor: "#fff",
				            pointBorderWidth: 1,
				            pointHoverRadius: 5,
				            pointHoverBackgroundColor: "rgba(75,192,192,1)",
				            pointHoverBorderColor: "rgba(220,220,220,1)",
				            pointHoverBorderWidth: 2,
				            pointRadius: 1,
				            pointHitRadius: 10,
				            data: responseJSON.area.areacountlist,
				        }
				    ]
				};
		 window.myAreaChart = new Chart(ctx,{
			    data: areadata,
			    type: "line",
			    options: {
			    }
			});
		 
		 
		 
		 
		 
		 
		 $("#univchart").remove();
		 $("#univchartdiv").append('<canvas id="univchart" width="400" height="400"></canvas>');
		 
		 
		 
		 var ctx = document.getElementById("univchart");
		 var univdata= {
				    labels: responseJSON.univ.univlist,
				    datasets: [
				        {
				        	label: "Count",
				            fill: false,
				            lineTension: 0.1,
				            backgroundColor: "rgba(75,192,192,0.4)",
				            borderColor: "rgba(75,192,192,1)",
				            borderCapStyle: 'butt',
				            borderDash: [],
				            borderDashOffset: 0.0,
				            borderJoinStyle: 'miter',
				            pointBorderColor: "rgba(75,192,192,1)",
				            pointBackgroundColor: "#fff",
				            pointBorderWidth: 1,
				            pointHoverRadius: 5,
				            pointHoverBackgroundColor: "rgba(75,192,192,1)",
				            pointHoverBorderColor: "rgba(220,220,220,1)",
				            pointHoverBorderWidth: 2,
				            pointRadius: 1,
				            pointHitRadius: 10,
				            data: responseJSON.univ.univcountlist,
				        }
				    ]
				};
		 window.myUnivChart = new Chart(ctx,{
			    data: univdata,
			    type: "line",
			    options: {
			    }
			});
		 
		 
		 
		 
		 
		 $("#malechart").remove();
		 $("#malechartdiv").append('<canvas id="malechart" width="400" height="400"></canvas>');
		 
		 
		 var ctx = document.getElementById("malechart");
		 var total5=responseJSON.malevotes[0]+responseJSON.malevotes[1]+responseJSON.malevotes[2]+responseJSON.malevotes[3];
		 window.myAnswerChart = new Chart(ctx, {
		     type: 'bar',
		     data: {
		         labels: ["A("+responseJSON.malevotes[0]+")","B("+responseJSON.malevotes[1]+")","C("+responseJSON.malevotes[2]+")","D("+responseJSON.malevotes[3]+")"],
		         datasets: [{
		             label: '% of Votes',
		             backgroundColor: "#51D071",
		             borderColor: "#003E28",
		             borderWidth: 1,
		             hoverBackgroundColor: "#118F62",
		             hoverBorderColor: "#003E28",
		             data:[Math.round(responseJSON.malevotes[0]/total5*100),Math.round(responseJSON.malevotes[1]/total5*100),Math.round(responseJSON.malevotes[2]/total5*100),Math.round(responseJSON.malevotes[3]/total5*100)]
		         }]
		     },
		     options: {
		         scales: {
		             yAxes: [{
		                 ticks: {
		                     beginAtZero:true
		                 }
		             }]
		         }
		     }
		 }).update();
		 
		 
		 
		 
		 
		 
		 $("#femalechart").remove();
		 $("#femalechartdiv").append('<canvas id="femalechart" width="400" height="400"></canvas>');
		 
		 
		 var ctx = document.getElementById("femalechart");
		 var total6=responseJSON.femalevotes[0]+responseJSON.femalevotes[1]+responseJSON.femalevotes[2]+responseJSON.femalevotes[3];
		 window.myAnswerChart = new Chart(ctx, {
		     type: 'bar',
		     data: {
		         labels: ["A("+responseJSON.femalevotes[0]+")","B("+responseJSON.femalevotes[1]+")","C("+responseJSON.femalevotes[2]+")","D("+responseJSON.femalevotes[3]+")"],
		         datasets: [{
		             label: '% of Votes',
		             backgroundColor: "#51D071",
		             borderColor: "#003E28",
		             borderWidth: 1,
		             hoverBackgroundColor: "#118F62",
		             hoverBorderColor: "#003E28",
		             data:[Math.round(responseJSON.femalevotes[0]/total6*100),Math.round(responseJSON.femalevotes[1]/total6*100),Math.round(responseJSON.femalevotes[2]/total6*100),Math.round(responseJSON.femalevotes[3]/total6*100)]
		         }]
		     },
		     options: {
		         scales: {
		             yAxes: [{
		                 ticks: {
		                     beginAtZero:true
		                 }
		             }]
		         }
		     }
		 }).update();
		 
		 
		 
		 
		 
		 

	 });
	
	})
	
	
		$('body').on('click','.univelement',function(){
		
		$disableelement=$(this).attr('id');
		$disabletype="university"
		$("#deleteModal").modal("show");
		
	
	})
	
			$('body').on('click','.categoryelement',function(){
		
		$disableelement=$(this).attr('id');
		$disabletype="category"
		$("#deleteModal").modal("show");
		
	
	})
	
			$('body').on('click','.areaelement',function(){
		
		$disableelement=$(this).attr('id');
		$disabletype="area"
		$("#deleteModal").modal("show");
		
	
	})
	
	
	
				$('body').on('click','#deletebtn',function(){
		
					 $.post('UnivAreaDisableController', {actionType:$disabletype,ID:$disableelement}, function() {

						 location.reload(true);
					 });
		
	
	})
	
	
	
	$('body').on('click','#searchbutton',function(){
		
		$searchstring=$('#searchstring').val();
		 $.post('PollSearchController', {searchstring:$searchstring}, function() {


	 });
	
	})
	
	

	$(document).on('change', '.btn-file :file', function() {
		var input = $(this),
		numFiles = input.get(0).files ? input.get(0).files.length : 1,
		label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
		input.trigger('fileselect', [numFiles, label]);
		
	});

	$(document).ready( function() {
		$('.btn-file :file').on('fileselect', function(event, numFiles, label) {

			var input = $(this).parents('.input-group').find(':text'),
			log = numFiles > 1 ? numFiles + ' files selected' : label;

			if( input.length ) {
				input.val(log);
			} else {
				if( log ) alert(log);
			}

		});
	});
	
    $("#imgsrc").change(function(){
        readURL(this);
    });
	
	
	
	
})

	function previewModal()
	{
	if($('#polltype').val()==='binary')
		{
		$("#answerbox1").hide();
		$("#answerbox2").hide();
		
		}
	else
		{
		$("#answerbox1").show();
		$("#answerbox2").show();
		
		}
		$('#previewtitle').html($('#question').val());
		$('#previewdesc').html($('#description').val());
		$('#previewA').html($('#optionA').val());
		$('#previewB').html($('#optionB').val());
		$('#previewC').html($('#optionC').val());
		$('#previewD').html($('#optionD').val());
		
		
		
	}

	function binary() {
		$('#polltype').val('binary');
		$('#multipleOptions').hide();
	}
	function multiple() {
		$('#polltype').val('multiple');
		$('#multipleOptions').show();
	}
	
	
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('#imagediv').attr('src', e.target.result);
            }
            
            reader.readAsDataURL(input.files[0]);
        }
    }

