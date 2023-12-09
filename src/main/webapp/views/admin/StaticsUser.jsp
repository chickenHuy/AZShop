<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <main class="page-content">
    <h6 class="mb-0 fw-bold">User Statistic</h6>
    <div>&nbsp;</div>
        <div class="row g-3">
            <div class="col-auto flex-grow-1 overflow-auto">
                <form action="/AZShop/admin/UserStatic" method="get" class="d-flex">
                    <!-- Use input type "date" for selecting a date -->
                    <input type="date" id="selectedDate" name="selectedDate" class="form-control">
                    
                    <div class="mx-2"></div>
                    
                    <!-- Khoảng trắng giữa select và button -->
                    <button type="submit" class="btn btn-primary">Filter</button>
                </form>
            </div>
        </div>
        <div>&nbsp;</div>
        
        <div class="row">
            <div class="col">
                <div class="card radius-10 border-0 border-start border-primary border-4">
                    <div class="card-body">
                        <div class="d-flex align-items-center">
                            <div class="">
                                <p class="mb-1">New User</p>
                                <h4 class="mb-0 text-primary">${count}</h4>
                            </div>
                            <div class="ms-auto widget-icon bg-primary text-white">
                                <i class="bi bi-basket2-fill"></i>
                            </div>
                        </div>
                        <div class="progress mt-3" style="height: 4.5px;">
                            <div class="progress-bar" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col">
                <div class="card radius-10 border-0 border-start border-success border-4">
                    <div class="card-body">
                        <div class="d-flex align-items-center">
                            <div class="">
                                <p class="mb-1">Total User</p>
                                <h4 class="mb-0 text-success">${total}</h4>
                            </div>
                            <div class="ms-auto widget-icon bg-success text-white">
                                <i class="bi bi-currency-dollar"></i>
                            </div>
                        </div>
                        <div class="progress mt-3" style="height: 4.5px;">
                            <div class="progress-bar bg-success" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        		
        	

				  	      
       	 		 <h6 class="mb-0 fw-bold">Statistic</h6>
	              <div class="card-body">
	                   <div id="chart2" style="min-height: 233.7px;"><div id="apexchartszs15apyt" class="apexcharts-canvas apexchartszs15apyt apexcharts-theme-light" style="width: 684px; height: 233.7px;"><svg id="SvgjsSvg1501" width="684" height="233.7" xmlns="http://www.w3.org/2000/svg" version="1.1" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.dev" class="apexcharts-svg" xmlns:data="ApexChartsNS" transform="translate(0, 0)" style="background: transparent;"><g id="SvgjsG1503" class="apexcharts-inner apexcharts-graphical" transform="translate(227.5, 0)"><defs id="SvgjsDefs1502"><clippath id="gridRectMaskzs15apyt"><rect id="SvgjsRect1505" width="237" height="255" x="-3" y="-1" rx="0" ry="0" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0" fill="#fff"></rect></clippath><clippath id="forecastMaskzs15apyt"></clippath><clippath id="nonForecastMaskzs15apyt"></clippath><clippath id="gridRectMarkerMaskzs15apyt"><rect id="SvgjsRect1506" width="235" height="257" x="-2" y="-2" rx="0" ry="0" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0" fill="#fff"></rect></clippath></defs><g id="SvgjsG1507" class="apexcharts-pie"><g id="SvgjsG1508" transform="translate(0, 0) scale(1)"><circle id="SvgjsCircle1509" r="85.34634146341465" cx="115.5" cy="115.5" fill="transparent"></circle><g id="SvgjsG1510" class="apexcharts-slices"><g id="SvgjsG1511" class="apexcharts-series apexcharts-pie-series" seriesName="Mobile" rel="1" data:realIndex="0"><path id="SvgjsPath1512" d="M 115.5 8.817073170731703 A 106.6829268292683 106.6829268292683 0 0 1 220.56217345549751 96.9747041679231 L 199.549738764398 100.67976333433847 A 85.34634146341465 85.34634146341465 0 0 0 115.5 30.153658536585354 L 115.5 8.817073170731703 z" fill="rgba(25,135,84,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-0" index="0" j="0" data:angle="80" data:startAngle="0" data:strokeWidth="2" data:value="10" data:pathOrig="M 115.5 8.817073170731703 A 106.6829268292683 106.6829268292683 0 0 1 220.56217345549751 96.9747041679231 L 199.549738764398 100.67976333433847 A 85.34634146341465 85.34634146341465 0 0 0 115.5 30.153658536585354 L 115.5 8.817073170731703 z" stroke="#ffffff"></path></g><g id="SvgjsG1513" class="apexcharts-series apexcharts-pie-series" seriesName="Desktop" rel="2" data:realIndex="1"><path id="SvgjsPath1514" d="M 220.56217345549751 96.9747041679231 A 106.6829268292683 106.6829268292683 0 1 1 10.437826544502485 96.97470416792308 L 31.450261235601985 100.67976333433846 A 85.34634146341465 85.34634146341465 0 1 0 199.549738764398 100.67976333433847 L 220.56217345549751 96.9747041679231 z" fill="rgba(13,110,253,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-1" index="0" j="1" data:angle="200" data:startAngle="80" data:strokeWidth="2" data:value="25" data:pathOrig="M 220.56217345549751 96.9747041679231 A 106.6829268292683 106.6829268292683 0 1 1 10.437826544502485 96.97470416792308 L 31.450261235601985 100.67976333433846 A 85.34634146341465 85.34634146341465 0 1 0 199.549738764398 100.67976333433847 L 220.56217345549751 96.9747041679231 z" stroke="#ffffff"></path></g><g id="SvgjsG1515" class="apexcharts-series apexcharts-pie-series" seriesName="Tablet" rel="3" data:realIndex="2"><path id="SvgjsPath1516" d="M 10.437826544502485 96.97470416792308 A 106.6829268292683 106.6829268292683 0 0 1 115.48138031680617 8.817074795605592 L 115.48510425344493 30.153659836484465 A 85.34634146341465 85.34634146341465 0 0 0 31.450261235601985 100.67976333433846 L 10.437826544502485 96.97470416792308 z" fill="rgba(220,53,69,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-2" index="0" j="2" data:angle="80" data:startAngle="280" data:strokeWidth="2" data:value="10" data:pathOrig="M 10.437826544502485 96.97470416792308 A 106.6829268292683 106.6829268292683 0 0 1 115.48138031680617 8.817074795605592 L 115.48510425344493 30.153659836484465 A 85.34634146341465 85.34634146341465 0 0 0 31.450261235601985 100.67976333433846 L 10.437826544502485 96.97470416792308 z" stroke="#ffffff"></path></g></g></g></g><line id="SvgjsLine1517" x1="0" y1="0" x2="231" y2="0" stroke="#b6b6b6" stroke-dasharray="0" stroke-width="1" stroke-linecap="butt" class="apexcharts-ycrosshairs"></line><line id="SvgjsLine1518" x1="0" y1="0" x2="231" y2="0" stroke-dasharray="0" stroke-width="0" stroke-linecap="butt" class="apexcharts-ycrosshairs-hidden"></line></g><g id="SvgjsG1504" class="apexcharts-annotations"></g></svg><div class="apexcharts-legend" style="max-height: 127.5px;"></div><div class="apexcharts-tooltip apexcharts-theme-dark"><div class="apexcharts-tooltip-series-group" style="order: 1;"><span class="apexcharts-tooltip-marker" style="background-color: rgb(25, 135, 84);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label"></span><span class="apexcharts-tooltip-text-y-value"></span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div><div class="apexcharts-tooltip-series-group" style="order: 2;"><span class="apexcharts-tooltip-marker" style="background-color: rgb(13, 110, 253);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label"></span><span class="apexcharts-tooltip-text-y-value"></span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div><div class="apexcharts-tooltip-series-group" style="order: 3;"><span class="apexcharts-tooltip-marker" style="background-color: rgb(220, 53, 69);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label"></span><span class="apexcharts-tooltip-text-y-value"></span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div></div></div></div>
	              </div>
	
	              <ul class="list-group list-group-flush mb-0">
	                <li class="list-group-item border-top d-flex justify-content-between align-items-center bg-transparent">New User<span class="badge bg-success rounded-pill">${((count/total)*100)}%</span>
	                </li>
	                <li class="list-group-item d-flex justify-content-between align-items-center bg-transparent">Other user<span class="badge bg-primary rounded-pill">${(((total-count)/total)*100)}%</span>
	                </li>
	                <li class="list-group-item d-flex justify-content-between align-items-center bg-transparent">Total<span class="badge bg-danger rounded-pill">100%</span>
	                </li>
	              </ul>
            
              
     
    </main>
</body>
</html>
