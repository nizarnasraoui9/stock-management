import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/layout/header/header.component';
import { SidebarComponent } from './components/layout/sidebar/sidebar.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { DashboardComponent } from './components/pages/dashboard/dashboard.component';
import { CreateCategoryComponent } from './components/pages/categories/create/create-category.component';
import { ListCategoriesComponent } from './components/pages/categories/list/list-categories.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { ToastrModule } from 'ngx-toastr'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EditComponent } from './components/pages/categories/edit/edit.component';
import { ListsubcategoriesComponent } from './components/pages/subcategories/listsubcategories/listsubcategories.component';
import { CreatesubcategoryComponent } from './components/pages/subcategories/createsubcategory/createsubcategory.component';
import { EditsubcategoryComponent } from './components/pages/subcategories/editsubcategory/editsubcategory.component';
import { ListBrandsComponent } from './components/pages/brand/list-brands/list-brands.component';
import { CreateBrandComponent } from './components/pages/brand/create-brand/create-brand.component';
import { EditBrandComponent } from './components/pages/brand/edit-brand/edit-brand.component';
import { SettingsComponent } from './components/pages/settings/settings/settings.component';
import { ListPartsComponent } from './components/pages/part/list-parts/list-parts.component';
import { CreatePartComponent } from './components/pages/part/create-part/create-part.component';
import { EditPartComponent } from './components/pages/part/edit-part/edit-part.component';


import { CreateComponent } from './components/pages/manufactures/create/create.component';
import { ListComponent } from './components/pages/manufactures/list/list.component';


import { CreatesubsubcategoriesComponent } from './components/pages/subsubcategories/createsubsubcategories/createsubsubcategories.component';
import { ListsubsubcategoriesComponent } from './components/pages/subsubcategories/listsubsubcategories/listsubsubcategories.component';
import { EditsubsubcategoriesComponent } from './components/pages/subsubcategories/editsubsubcategories/editsubsubcategories.component';
import { CreatemodelComponent } from './components/pages/models/createmodel/createmodel.component';
import { EditmodelComponent } from './components/pages/models/editmodel/editmodel.component';
import { ListmodelsComponent } from './components/pages/models/listmodels/listmodels.component';
import { ListsubmodelsComponent } from './components/pages/submodels/listsubmodels/listsubmodels.component';
import { EditsubmodelsComponent } from './components/pages/submodels/editsubmodels/editsubmodels.component';
import { CreatesubmodelsComponent } from './components/pages/submodels/createsubmodels/createsubmodels.component';

import { ListenginesComponent } from './components/pages/engines/listengines/listengines.component';
import { EditenginesComponent } from './components/pages/engines/editengines/editengines.component';
import { EditMComponent } from './components/pages/manufactures/edit-m/edit-m.component';
import { CreateengineComponent } from './components/pages/engines/createengine/createengine.component';
import { ImageComponent } from './components/pages/image/image.component';
import { HomeComponent } from './components/pages/home/home.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { NgSelectModule } from '@ng-select/ng-select';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    FooterComponent,
    DashboardComponent,
    CreateCategoryComponent,
    ListCategoriesComponent,

    EditComponent,
    ListsubcategoriesComponent,
    CreatesubcategoryComponent,
    EditsubcategoryComponent,
    ListBrandsComponent,
    CreateBrandComponent,
    EditBrandComponent,
    SettingsComponent,
    ListPartsComponent,
    CreatePartComponent,
    EditPartComponent,
    EditMComponent,


    CreateComponent,
    ImageComponent,
    ListComponent,

    CreatesubsubcategoriesComponent,
    ListsubsubcategoriesComponent,
    EditsubsubcategoriesComponent,
    CreatemodelComponent,
    EditmodelComponent,
    ListmodelsComponent,
    ListsubmodelsComponent,
    EditsubmodelsComponent,
    CreatesubmodelsComponent,

    ListenginesComponent,
    EditenginesComponent,
    CreateengineComponent,
    ImageComponent,
    HomeComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    
    BrowserAnimationsModule,
    NgMultiSelectDropDownModule.forRoot(),
    ReactiveFormsModule,
    NgSelectModule



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
