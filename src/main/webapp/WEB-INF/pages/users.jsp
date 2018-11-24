<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Admin Panel | Users</title>

    <!-- Bootstrap core CSS -->

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/ad/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="css/ad/custom.css" rel="stylesheet">
    <link href="css/ad/icheck/flat/green.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
    <!-- Backgrid -->
    <link rel="stylesheet" href="css/backgrid/backgrid.css">
    <link rel="stylesheet" href="css/backgrid/backgrid-select-all.css">
    <link rel="stylesheet" href="css/backgrid/backgrid-paginator.css">
    <link rel="stylesheet" href="css/backgrid/backgrid-filter.css">

    <script src="js/ad/jquery.min.js"></script>

    <!--[if lt IE 9]>
    <script src="js/ad/ie8-responsive-file-warning.js"></script>
    <![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>


<body class="nav-md">

<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">

                <div class="navbar nav_title" style="border: 0;">
                    <a href="../index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentellela Alela!</span></a>
                </div>
                <div class="clearfix"></div>

                <!-- menu prile quick info -->
                <div class="profile">
                    <div class="profile_pic">
                        <img src="images/img.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2>Anthony Fernando</h2>
                    </div>
                </div>
                <!-- /menu prile quick info -->

                <br />

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="../index.html">Dashboard</a>
                                    </li>
                                    <li><a href="../index2.html">Dashboard2</a>
                                    </li>
                                    <li><a href="../index3.html">Dashboard3</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="../form.html">General Form</a>
                                    </li>
                                    <li><a href="../form_advanced.html">Advanced Components</a>
                                    </li>
                                    <li><a href="../form_validation.html">Form Validation</a>
                                    </li>
                                    <li><a href="../form_wizards.html">Form Wizard</a>
                                    </li>
                                    <li><a href="../form_upload.html">Form Upload</a>
                                    </li>
                                    <li><a href="../form_buttons.html">Form Buttons</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="../general_elements.html">General Elements</a>
                                    </li>
                                    <li><a href="../media_gallery.html">Media Gallery</a>
                                    </li>
                                    <li><a href="../typography.html">Typography</a>
                                    </li>
                                    <li><a href="../icons.html">Icons</a>
                                    </li>
                                    <li><a href="../glyphicons.html">Glyphicons</a>
                                    </li>
                                    <li><a href="../widgets.html">Widgets</a>
                                    </li>
                                    <li><a href="../invoice.html">Invoice</a>
                                    </li>
                                    <li><a href="../inbox.html">Inbox</a>
                                    </li>
                                    <li><a href="../calender.html">Calender</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-table"></i> Users <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="../tables.html">Active Users</a>
                                    </li>
                                    <li><a href="tables_dynamic.html">All Users</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> Products <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="products.jsp">Product Categories</a>
                                    </li>
                                    <li><a href="product-all.html">All Products</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="../chartjs.html">Chart JS</a>
                                    </li>
                                    <li><a href="../chartjs2.html">Chart JS2</a>
                                    </li>
                                    <li><a href="../morisjs.html">Moris JS</a>
                                    </li>
                                    <li><a href="../echarts.html">ECharts </a>
                                    </li>
                                    <li><a href="../other_charts.html">Other Charts </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="menu_section">
                        <h3>Live On</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="../e_commerce.html">E-commerce</a>
                                    </li>
                                    <li><a href="../projects.html">Projects</a>
                                    </li>
                                    <li><a href="../project_detail.html">Project Detail</a>
                                    </li>
                                    <li><a href="../contacts.html">Contacts</a>
                                    </li>
                                    <li><a href="../profile.html">Profile</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="../page_404.html">404 Error</a>
                                    </li>
                                    <li><a href="../page_500.html">500 Error</a>
                                    </li>
                                    <li><a href="../plain_page.html">Plain Page</a>
                                    </li>
                                    <li><a href="../login.html">Login Page</a>
                                    </li>
                                    <li><a href="../pricing_tables.html">Pricing Tables</a>
                                    </li>

                                </ul>
                            </li>
                            <li><a><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">

            <div class="nav_menu">
                <nav class="" role="navigation">
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <img src="images/img.jpg" alt="">John Doe
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                <li><a href="javascript:;">  Profile</a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="badge bg-red pull-right">50%</span>
                                        <span>Settings</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">Help</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                </li>
                            </ul>
                        </li>

                        <li role="presentation" class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">6</span>
                            </a>
                            <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                <li>
                                    <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                        <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                        <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                        <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                        <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                        <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                        <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                        <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                        <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                                    </a>
                                </li>
                                <li>
                                    <div class="text-center">
                                        <a>
                                            <strong>See All Alerts</strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </nav>
            </div>

        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>
                            Invoice
                            <small>
                                Some examples to get you started
                            </small>
                        </h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for...">
                                <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>

                <div class="row">

                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Daily active users <small>Sessions</small></h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a href="#"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Settings 1</a>
                                            </li>
                                            <li><a href="#">Settings 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="#"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <div id="backgrid-table" class="backgrid-container"></div>
                            </div>
                        </div>
                    </div>

                    <br />
                    <br />
                    <br />

                </div>
            </div>
            <div><button id="saveAll" class="btn" disabled>Save Changes</button></div>
            <!-- footer content -->
            <footer>
                <div class="">
                    <p class="pull-right">Gentelella Alela! a Bootstrap 3 template by <a>Kimlabs</a>. |
                        <span class="lead"> <i class="fa fa-paw"></i> Gentelella Alela!</span>
                    </p>
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->

        </div>
        <!-- /page content -->
    </div>

</div>

<div id="custom_notifications" class="custom-notifications dsp_none">
    <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
    </ul>
    <div class="clearfix"></div>
    <div id="notif-group" class="tabbed_notifications"></div>
</div>

<script src="js/ad/bootstrap.min.js"></script>

<!-- chart js -->
<script src="js/ad/chartjs/chart.js"></script>
<!-- bootstrap progress js -->
<script src="js/ad/progressbar/bootstrap-progressbar.min.js"></script>
<script src="js/ad/nicescroll/jquery.nicescroll.min.js"></script>
<!-- icheck -->
<script src="js/ad/icheck/icheck.min.js"></script>

<script src="js/ad/custom.js"></script>

<!-- pace -->
<script src="js/ad/pace/pace.min.js"></script>


<script src="js/lib/underscore/underscore.js"></script>
<script src="js/lib/backbone/backbone.js"></script>
<script src="js/lib/backbone/backbone-pageable.js"></script>
<script src="js/lib/backbone/backbone-dotattr.js"></script>
<script src="js/lib/backgrid/backgrid.js"></script>
<script src="js/lib/backgrid/backgrid-select-all.js"></script>
<script src="js/lib/backgrid/backgrid-paginator.js"></script>
<script src="js/lib/backgrid/backgrid-filter.js"></script>
<script>
    $(function() {


        // define Remove Button & its action
        var ActionCell = Backgrid.Cell.extend({
            events: {
                'click button#removeRowBtn': 'deleteRow',
                'click button#editBtn': 'editRow'
            },
            editRow: function(e){
                e.preventDefault();
                console.log('Edit button pressed');
                console.log('selected: '+ this.model.get('userName'));
            },
            deleteRow: function(e){
                e.preventDefault();
                console.log('Deleting: '+ this.model.get('userName'));
                this.model.collection.remove(this.model);
            },
            className: 'removeButton',
            render: function(){
                this.$el.html('<button id="editBtn" class="btn btn-primary btn-xs glyphicon glyphicon-edit" type="button"></button>' +
                    '<button id="removeRowBtn" data-toggle="modal" data-target="#myModal" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> </button>\n' +
                    ' <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">\n' +
                    '  <div class="modal-dialog" role="document">\n' +
                    '    <div class="modal-content">\n' +
                    '      <div class="modal-header">\n' +
                    '        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>\n' +
                    '        <h4 class="modal-title" id="myModalLabel">Modal title</h4>\n' +
                    '      </div>\n' +
                    '      <div class="modal-body">\n' +
                    '        some text\n' +
                    '      </div>\n' +
                    '      <div class="modal-footer">\n' +
                    '        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>\n' +
                    '        <button type="button" class="btn btn-primary">Save changes</button>\n' +
                    '      </div>\n' +
                    '    </div>\n' +
                    '  </div>\n' +
                    '</div>');
                //this.undelegateEvents();
                return this;
            }
        });
        var MyCell = Backgrid.Cell.extend({
            initialize: function (options) {
                MyCell.__super__.initialize.apply(this, arguments);
                console.log('initializing MyCell');
                this.listenTo(this.model, "backgrid:edited", this.doSomething);
            },
            doSomething: function () {
                console.log('doSomething');
            },
            enterEditMode: function () {
                this.$el.width((this.$el.outerWidth() - 10) + 'px');
                Backgrid.Cell.prototype.enterEditMode.apply(this, arguments);
                console.log('enterEditMode');
                console.log('target data: '+ this.model.get('userName'));
            },
            exitEditMode: function () {
                this.$el.width(false);
                Backgrid.Cell.prototype.exitEditMode.apply(this, arguments);
                console.log('exitEditMode');
            }
        });

        var columns = [{
                name: "userName", // The key of the model attribute
                label: "Username", // The name to display in the header
                editable: false, // By default every cell in a column is editable, but *ID* shouldn't be
                // Defines a cell type, and ID is displayed as an integer without the ',' separating 1000s.
                cell: "string"
            }, {
                name: "firstName",
                label: "First Name",
                cell: "string"
            }, {
                name: "lastName",
                label: "Last Name",
                cell: "string"
            }, {
                name: "email",
                label: "Email Id",
                // The cell type can be a reference of a Backgrid.Cell subclass, any Backgrid.Cell subclass instances like *id* above, or a string
                cell: "string" // This is converted to "StringCell" and a corresponding class in the Backgrid package namespace is looked up
            }, {
                name: "userPrivilege.privilegeType",
                label: "User Type",
                // The cell type can be a reference of a Backgrid.Cell subclass, any Backgrid.Cell subclass instances like *id* above, or a string
                cell: "string" // This is converted to "StringCell" and a corresponding class in the Backgrid package namespace is looked up
            }, {
                name: "loginStatus",
                label: "Login Status",
                cell: "boolean"
            }, {
                name: "userPassword",
                label: "Password",
                cell: MyCell,
                editable: function (c, m) {
                    if (typeof(c.collection) === 'undefined')
                        return false;
                    else
                    // editable is true; only if user is not logged
                        return (c.attributes.loginStatus === false) ? true : false;
                }
            }, {
                name: "",
                label: "Action",
                cell: ActionCell
            } ]
        ;

        /// save changes to the server immediately
        var User = Backbone.Model.extend({
            initialize: function() {
                //Backbone.Model.prototype.initialize.apply(this, arguments);
                this.on("change", function(model, options) {
                    if (options && options.save === false) return;
                    //var d =model.fetch();
                    /* Change background for those modified rows
                    var modelId = pageableUsers.indexOf(model) + 1;
                    console.log(modelId);
                    var changedCell = $('tr:eq('+modelId+')');
                    changedCell.css("background-color","yellow");*/
                    var saveChangesButton = $('button#saveAll');
                    saveChangesButton.addClass('btn-primary');
                    saveChangesButton.removeAttr('disabled');
                    //console.log(model);

                    model.url = "user/update";

                    //console.log(pageableUsers.toJSON());
                    model.save();
                    saveChangesButton.click(function(){
                        Backbone.emulateJSON = true;
                        /*model.save({}, {
                            type: "PUT",
                            success: function (model, respose, options) {
                                console.log("The model has been saved to the server");
                            },
                            error: function (model, xhr, options) {
                                console.log("Something went wrong while saving the model");
                            }
                        });*/
                         model.sync("update", model, "error: function(){" +
                             "console.log('successful request')}");

                    });
                    //console.log(pageableUsers.toJSON());
                    model.off("change", null, this); // prevent the change event from     being triggered many times.
                });
            }
        });

        /*var DomButtonSave = Backbone.View.extend({
            el: $("#saveAll"),
            tagName: 'button',
            events: {
                'click button#saveAll': 'init'
            },
            init: function () {
                console.log("dsd");
            }
        });*/


        var PageableUsers = Backbone.PageableCollection.extend({
            model: User,
            url: "user/all.json",
            state: {
                pageSize: 15
            },
            mode: "client" // page entirely on the client side
        });

        // Set up a grid to use the pageable collection
        var pageableUsers = new PageableUsers();

        // Initialize a new Grid instance
        var pageableGrid = new Backgrid.Grid({
            columns: [{
                // enable the select-all extension
                name: "?????????????Name?",
                cell: "select-row",
                headerCell: "select-all"
            }].concat(columns),
            collection: pageableUsers,
            className: "backgrid table-bordered table-hover table-striped table-responsive"
        });

        //console.log(pageableUsers.length);

        // Render the grid
        var $tableView = $("#backgrid-table");
        $tableView.append(pageableGrid.render().el);

        // Initialize the paginator
        var paginator = new Backgrid.Extension.Paginator({
            collection: pageableUsers
        });

        // Render the paginator
        $tableView.after(paginator.render().el);

        // Initialize a client-side filter to filter on the client
        // mode pageable collection's cache.
        var filter = new Backgrid.Extension.ClientSideFilter({
            collection: pageableUsers,
            fields: ['firstName', 'lastName']
        });

        // Render the filter
        $tableView.before(filter.render().el);

        // Add some space to the filter and move it to the right
        $(filter.el).css({
            float: "right",
            margin: "20px"
        });

        // Fetch some data
        pageableUsers.fetch({
            reset: true
        });



    });

</script>
</body>

</html>