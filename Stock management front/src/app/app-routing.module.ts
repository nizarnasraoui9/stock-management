import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateBrandComponent } from './components/pages/brand/create-brand/create-brand.component';
import { EditBrandComponent } from './components/pages/brand/edit-brand/edit-brand.component';
import { ListBrandsComponent } from './components/pages/brand/list-brands/list-brands.component';
import { CreateCategoryComponent } from './components/pages/categories/create/create-category.component';
import { EditComponent } from './components/pages/categories/edit/edit.component';

import { ListCategoriesComponent } from './components/pages/categories/list/list-categories.component';
import { DashboardComponent } from './components/pages/dashboard/dashboard.component';
import { CreateengineComponent } from './components/pages/engines/createengine/createengine.component';


import { EditenginesComponent } from './components/pages/engines/editengines/editengines.component';
import { ListenginesComponent } from './components/pages/engines/listengines/listengines.component';
import { ImageComponent } from './components/pages/image/image.component';
import { CreateComponent } from './components/pages/manufactures/create/create.component';
import { EditMComponent } from './components/pages/manufactures/edit-m/edit-m.component';
import { ListComponent } from './components/pages/manufactures/list/list.component';
import { CreatemodelComponent } from './components/pages/models/createmodel/createmodel.component';
import { EditmodelComponent } from './components/pages/models/editmodel/editmodel.component';
import { ListmodelsComponent } from './components/pages/models/listmodels/listmodels.component';
import { CreatePartComponent } from './components/pages/part/create-part/create-part.component';
import { EditPartComponent } from './components/pages/part/edit-part/edit-part.component';
import { ListPartsComponent } from './components/pages/part/list-parts/list-parts.component';
import { SettingsComponent } from './components/pages/settings/settings/settings.component';
import { CreatesubcategoryComponent } from './components/pages/subcategories/createsubcategory/createsubcategory.component';
import { EditsubcategoryComponent } from './components/pages/subcategories/editsubcategory/editsubcategory.component';
import { ListsubcategoriesComponent } from './components/pages/subcategories/listsubcategories/listsubcategories.component';
import { CreatesubmodelsComponent } from './components/pages/submodels/createsubmodels/createsubmodels.component';
import { EditsubmodelsComponent } from './components/pages/submodels/editsubmodels/editsubmodels.component';
import { ListsubmodelsComponent } from './components/pages/submodels/listsubmodels/listsubmodels.component';
import { CreatesubsubcategoriesComponent } from './components/pages/subsubcategories/createsubsubcategories/createsubsubcategories.component';
import { EditsubsubcategoriesComponent } from './components/pages/subsubcategories/editsubsubcategories/editsubsubcategories.component';
import { ListsubsubcategoriesComponent } from './components/pages/subsubcategories/listsubsubcategories/listsubsubcategories.component';



const routes: Routes = [
  /* Dashboard routes */
  { path: '', redirectTo: 'dashboard', pathMatch: "full" },
  { path: 'dashboard', component: DashboardComponent},

  /* Users routes */
  /*{ path: 'listusers', component: ListUsersComponent},*/

  /* Categories routes */
  { path: 'listcategories', component: ListCategoriesComponent},
  { path: 'addcategorie', component: CreateCategoryComponent},
  {path: "editcategory/:id", component: EditComponent},

  /* SubCategories routes */
  { path: 'listsubcategories', component: ListsubcategoriesComponent},
  { path: 'addsubcategorie', component: CreatesubcategoryComponent},
  {path: "editsubcategory/:id", component: EditsubcategoryComponent},


  /*SubSubCategories routes */
  { path: 'listsubsubcategories', component: ListsubsubcategoriesComponent},
  { path: 'addsubsubcategorie', component: CreatesubsubcategoriesComponent},
  {path: "editsubsubcategory/:id", component: EditsubsubcategoriesComponent},

  /*Brands routes */
  { path: 'listbrands', component: ListBrandsComponent},
  { path: 'addbrand', component: CreateBrandComponent},
  {path: "editbrand/:id", component: EditBrandComponent},

  /*Models routes */
  { path: 'listmodels', component: ListmodelsComponent},
  { path: 'addmodel', component: CreatemodelComponent},
  {path: "editmodel/:id", component: EditmodelComponent},


  /*SubModels routes */
  { path: 'listsubmodels', component: ListsubmodelsComponent},
  { path: 'addsubmodel', component: CreatesubmodelsComponent},
  {path: "editsubmodel/:id", component: EditsubmodelsComponent},


   /*Engines routes */
   { path: 'listengines', component: ListenginesComponent},
   { path: 'addengine', component: CreateengineComponent},
   {path: "editengine/:id", component: EditenginesComponent},


  /*Parts routes */
  { path: 'listparts', component: ListPartsComponent},
  { path: 'addpart', component: CreatePartComponent},
  {path: "editbrand/:id", component: EditPartComponent},















  /* Settings routes */
  {path: "settings", component: SettingsComponent},

 /* { path: '', redirectTo: 'login', pathMatch: "full" },
  {path: 'login', component: LoginComponent}*/

  { path: 'listmanufactures', component: ListComponent},
  { path: 'addmanufacture', component: CreateComponent},
  {path: "editmanufacture/:id", component: EditMComponent},




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
