package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.*;
import com.tarazgroup.tws.model.crm.CrmCategory;
import com.tarazgroup.tws.model.crm.CrmFormBuilder;
import com.tarazgroup.tws.model.crm.CrmFormFieldValue;
import com.tarazgroup.tws.model.crm.CrmFormFieldValueWithMulti;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 9/11/22
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("crm/formfieldvalues")
@Validated
@Tag(name = "FormFieldValue")
public class CrmFormFieldValueController {

    private final CrmFormFieldValueRepository crmFormFieldValueRepository;
    private final CrmFormBuilderRepository crmFormBuilderRepository;
    private final CrmSelectorRepository crmSelectorRepository;
    private final CrmQKeyMapFieldRepository crmQKeyMapFieldRepository;

    public CrmFormFieldValueController(CrmFormFieldValueRepository crmFormFieldValueRepository, CrmFormBuilderRepository crmFormBuilderRepository, CrmSelectorRepository crmSelectorRepository, CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        this.crmFormFieldValueRepository = crmFormFieldValueRepository;
        this.crmFormBuilderRepository = crmFormBuilderRepository;
        this.crmSelectorRepository = crmSelectorRepository;
        this.crmQKeyMapFieldRepository = crmQKeyMapFieldRepository;
    }

    @Autowired
    HttpServletRequest httpServletRequest;

    //1
    @Operation(
            summary = "Retrieve all FormFieldValues",
            description = "<code>Retrieve</code> all <i><b>FormFieldValues</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
//    @GetMapping(path = {"/{formID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> formFieldValues(@PathVariable BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) throws UnsupportedEncodingException {

        return
                ResponseEntity
                        .ok()
                        .body(crmFormFieldValueRepository.crmShowFormFieldValue(formID, crmFormFieldValue));
    }


    //1
    @Operation(
            summary = "Retrieve all FormFieldValues",
            description = "<code>Retrieve</code> all <i><b>FormFieldValues</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = {"/{formID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> formFieldValuesNew(@PathVariable BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) throws UnsupportedEncodingException {

//        final String parameter = httpServletRequest.getParameter(String.valueOf(crmFormFieldValue));
//        final String[] parameterValues = httpServletRequest.getParameterValues(String.valueOf(crmFormFieldValue));

//        System.out.println("********************************************** " + httpServletRequest.getQueryString().toString() + " **************");
//        System.out.println("********************************************** " + httpServletRequest.getPathTranslated() + " **************");
//        System.out.println("https://www.google.com/search?client=firefox-b-d&q=%D8%B9%D8%AF%D9%85+%D9%86%D9%85%D8%A7%DB%8C%D8%B4+%D8%AF%D8%B1%D8%B3%D8%AA+%D9%85%D8%AA%D9%86+%D9%81%D8%A7%D8%B1%D8%B3%DB%8C+%D8%AF%D8%B1+%D8%A7%D8%B3%D9%BE%D8%B1%DB%8C%D9%86%DA%AF+%D8%A8%D9%88%D9%88%D8%AA");


        final String queryString = httpServletRequest.getQueryString();
//        System.out.println(queryString);

//        try {
        String queryParams = java.net.URLDecoder.decode(queryString, StandardCharsets.UTF_8.name());
//            System.out.println("Editedddddddddddddddddddddd " + result);
//        } catch (UnsupportedEncodingException e) {
        // not going to happen - value came from JDK's own StandardCharsets
//        }

        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);


        // START

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> names2 = new ArrayList<>();


        ArrayList<String> names3 = new ArrayList<>();
        ArrayList<String> values3 = new ArrayList<String>();
        ArrayList<Integer> types3 = new ArrayList<Integer>();
//        List<String> values3 = new ArrayList<String>();


        ArrayList<Type> types = new ArrayList<>();


        List<String> list = new ArrayList<String>(Arrays.asList(queryParams.split("&")));

        String[] split;

        for (int i = 0; i < list.size(); i++) {
//            System.out.println("CONTROLLER list.get(i) " + list.get(i));
//            System.out.println();
        }

//        System.out.println();
//        System.out.println("CONTROLLER WELCOME TO SECOND LOOP");

        List<String> values = new ArrayList<String>();
//        StringBuilder trimmed = new StringBuilder();
//        StringBuilder trimmed = new StringBuilder(new String());

        for (int i = 0; i < list.size(); i++) {
//            trimmed.append(list.get(i));
//            trimmed = trimmed + list.get(i).toString();
//            trimmed.append(list.get(i).toString());
//            List<String> list3 = new ArrayList<String>(Collections.singletonList(list.toString().substring(list.get(i).lastIndexOf("=") + 1)));
            values.add(list.get(i).substring(list.get(i).lastIndexOf("=") + 1));
//                        System.out.println("HEYYYYYYYYYYYYYYYYYYYYYYYY " + Arrays.toString(list.get(i).split("=")));
            names2.add(list.get(i));
            split = names2.get(i).toString().split("=");
//            System.out.println("CONTROLLER names2 " + names2.get(i));
            System.out.println();
//            System.out.println("CONTROLLER split[0] " + split[0]);
//            System.out.println("CONTROLLER split[1] " + split[1]);
            names3.add(split[0]);
            values3.add(split[1]);

//            System.out.println("split[0] " +split[2]);
//         names2.add(list.get(i)..split("=")));
//
//list.get(i).split("=");
//            System.out.println("CONTROLLER HEYYYYYYYYYYYYYYYYY " + names2.get(i));

//            System.out.println();
//            System.out.println("CONTROLLER values.get(i) " + values.get(i));
//            System.out.println("CONTROLLER split.length " + split.length);
        }
//        System.out.println("The trimmed list is: " + trimmed);

        CrmFormBuilder crmFormBuilder = new CrmFormBuilder();
        crmFormBuilder.setFormID(formID);
        for (int i = 0; i < names3.size(); i++) {
            try {
                crmFormBuilder.setFieldName(names3.get(i));
                List<CrmFormBuilder> crmFormBuilders3 = crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder);

                if (crmFormBuilders3 != null) {
//                    System.out.println(":CONTROLLER crmFormBuilders3.get(i)" + crmFormBuilders3.get(0).getFieldType().toString());
                    types3.add(crmFormBuilders3.get(0).getFieldType());
                }

            } catch (Exception e) {
                System.out.println("This Exception occurred");
                e.printStackTrace();
            }
        }

        for (int i = 0; i < types3.size(); i++) {
//            System.out.println("TYPEPERPSWERPSERSERSEPORSEPORKSEOPRKS"+ types3.get(i));
//            System.out.println("CIBTEDLDLA " + types3.get(i).toString());
        }

        // END


        return
                ResponseEntity
                        .ok()
                        .body(crmFormFieldValueRepository.crmShowFormFieldValueNew(formID, crmFormFieldValue, names3, values3, types3));
    }






    public ResponseEntity<List<Map<String, Object>>> formFieldValuesNewArchive(@PathVariable BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) throws UnsupportedEncodingException {

//        final String parameter = httpServletRequest.getParameter(String.valueOf(crmFormFieldValue));
//        final String[] parameterValues = httpServletRequest.getParameterValues(String.valueOf(crmFormFieldValue));

//        System.out.println("********************************************** " + httpServletRequest.getQueryString().toString() + " **************");
//        System.out.println("********************************************** " + httpServletRequest.getPathTranslated() + " **************");
//        System.out.println("https://www.google.com/search?client=firefox-b-d&q=%D8%B9%D8%AF%D9%85+%D9%86%D9%85%D8%A7%DB%8C%D8%B4+%D8%AF%D8%B1%D8%B3%D8%AA+%D9%85%D8%AA%D9%86+%D9%81%D8%A7%D8%B1%D8%B3%DB%8C+%D8%AF%D8%B1+%D8%A7%D8%B3%D9%BE%D8%B1%DB%8C%D9%86%DA%AF+%D8%A8%D9%88%D9%88%D8%AA");


        final String queryString = httpServletRequest.getQueryString();
//        System.out.println(queryString);

//        try {
        String queryParams = java.net.URLDecoder.decode(queryString, StandardCharsets.UTF_8.name());
//            System.out.println("Editedddddddddddddddddddddd " + result);
//        } catch (UnsupportedEncodingException e) {
        // not going to happen - value came from JDK's own StandardCharsets
//        }

        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);


        // START

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> names2 = new ArrayList<>();


        ArrayList<String> names3 = new ArrayList<>();
        ArrayList<String> values3 = new ArrayList<String>();
        ArrayList<Integer> types3 = new ArrayList<Integer>();
//        List<String> values3 = new ArrayList<String>();


        ArrayList<Type> types = new ArrayList<>();


        List<String> list = new ArrayList<String>(Arrays.asList(queryParams.split("&")));

        String[] split;

        for (int i = 0; i < list.size(); i++) {
            System.out.println("CONTROLLER list.get(i) " + list.get(i));
            System.out.println();
        }

        System.out.println();
        System.out.println("CONTROLLER WELCOME TO SECOND LOOP");

        List<String> values = new ArrayList<String>();
//        StringBuilder trimmed = new StringBuilder();
//        StringBuilder trimmed = new StringBuilder(new String());

        for (int i = 0; i < list.size(); i++) {
//            trimmed.append(list.get(i));
//            trimmed = trimmed + list.get(i).toString();
//            trimmed.append(list.get(i).toString());
//            List<String> list3 = new ArrayList<String>(Collections.singletonList(list.toString().substring(list.get(i).lastIndexOf("=") + 1)));
            values.add(list.get(i).substring(list.get(i).lastIndexOf("=") + 1));
//                        System.out.println("HEYYYYYYYYYYYYYYYYYYYYYYYY " + Arrays.toString(list.get(i).split("=")));
            names2.add(list.get(i));
            split = names2.get(i).toString().split("=");
            System.out.println("CONTROLLER names2 " + names2.get(i));
            System.out.println();
            System.out.println("CONTROLLER split[0] " + split[0]);
            System.out.println("CONTROLLER split[1] " + split[1]);
            names3.add(split[0]);
            values3.add(split[1]);

//            System.out.println("split[0] " +split[2]);
//         names2.add(list.get(i)..split("=")));
//
//list.get(i).split("=");
            System.out.println("CONTROLLER HEYYYYYYYYYYYYYYYYY " + names2.get(i));

            System.out.println();
            System.out.println("CONTROLLER values.get(i) " + values.get(i));
            System.out.println("CONTROLLER split.length " + split.length);
        }
//        System.out.println("The trimmed list is: " + trimmed);

        CrmFormBuilder crmFormBuilder = new CrmFormBuilder();
        crmFormBuilder.setFormID(formID);
        for (int i = 0; i < names3.size(); i++) {
            try {
                crmFormBuilder.setFieldName(names3.get(i));
                List<CrmFormBuilder> crmFormBuilders3 = crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder);

                if (crmFormBuilders3 != null) {
                    System.out.println(":CONTROLLER crmFormBuilders3.get(i)" + crmFormBuilders3.get(0).getFieldType().toString());
                    types3.add(crmFormBuilders3.get(0).getFieldType());
                }

            } catch (Exception e) {
                System.out.println("This Exception occurred");
                e.printStackTrace();
            }
        }

        for (int i = 0; i < types3.size(); i++) {
//            System.out.println("TYPEPERPSWERPSERSERSEPORSEPORKSEOPRKS"+ types3.get(i));
            System.out.println("CIBTEDLDLA " + types3.get(i).toString());
        }

        // END


        return
                ResponseEntity
                        .ok()
                        .body(crmFormFieldValueRepository.crmShowFormFieldValueNewArchive(formID, crmFormFieldValue, queryParams, crmFormBuilders, types3));
    }


    //  1.1
    @Operation(
            summary = "Retrieve all FormFieldValues with page filter",
            description = "<code>Retrieve</code> all <i><b>FormFieldValues with page filter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = {"/{formID}/pagefilter"}, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List<Map<String, Object>>> formFieldValuesWithPageFilter(@PathVariable BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {


        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);

        return
                ResponseEntity
                        .ok()
                        .body(crmFormFieldValueRepository.crmShowFormFieldValueWithPageFilter(formID, crmFormFieldValue, crmFormBuilders));
    }

    //  1.2
    @Operation(
            summary = "Retrieve all FormFieldValues with Majidi",
            description = "<code>Retrieve</code> all <i><b>FormFieldValues with Majidi</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = {"/{formID}/majidi"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> formFieldValuesWithPageFilterMajidi(@RequestParam Map<String, String> params, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
//        Map<String, String> params;

//        params.se
//        BigDecimal formID = new BigDecimal(params.get("formID"));
//        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);

        return
                ResponseEntity
                        .ok()
                        .body(crmFormFieldValueRepository.crmShowFormFieldValueMajidi(params, crmFormBuilderRepository, crmSelectorRepository, crmQKeyMapFieldRepository));
    }


    //  1.3
    @Operation(
            summary = "Retrieve all FormFieldValues with page filter",
            description = "<code>Retrieve</code> all <i><b>FormFieldValues with page filter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = {"/{formID}/stringurl"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> formFieldValuesWithPageFilter(@PathVariable BigDecimal formID, @RequestBody String crmFormFieldValue) {


        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);

        return
                ResponseEntity
                        .ok()
                        .body(crmFormFieldValueRepository.crmShowFormFieldValueWithString(formID, crmFormFieldValue));
    }


//    @RequestMapping(value = "/{formID}", method = RequestMethod.GET)
//    public ModelAndView getParameters(HttpServletRequest request) {
//
//        Enumeration enumeration = request.getParameterNames();
//        Map<String, Object> modelMap = new HashMap<>();
//        while (enumeration.hasMoreElements()) {
//            String parameterName = (String) enumeration.nextElement();
//            modelMap.put(parameterName, request.getParameter(parameterName));
//        }
//        ModelAndView modelAndView = new ModelAndView("sample");
//        modelAndView.addObject("parameters", modelMap);
//        return modelAndView;
//    }


    //  2
//    @Operation(
//            summary = "Retrieve Specific FormFieldValue",
//            description = "<code>Retrieve</code> specific <i><b>FormFieldValue</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(path = {"/{formID}/{recordID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Map<String, Object>>> formFieldValuesByID(@PathVariable BigDecimal formID, @PathVariable BigDecimal recordID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
//        return
//                ResponseEntity
//                        .ok()
//                        .body(crmFormFieldValueRepository.crmShowFormFieldValueByID(formID, recordID, crmFormFieldValue));
//    }

    //  2.1
    @Operation(
            summary = "Retrieve Specific FormFieldValue as an object",
            description = "<code>Retrieve</code> specific <i><b>FormFieldValue as an object</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = {"/{formID}/{recordID}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> formFieldValuesByIDObject(@PathVariable BigDecimal formID, @PathVariable BigDecimal recordID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
        return
                ResponseEntity
                        .ok()
                        .body(crmFormFieldValueRepository.crmShowFormFieldValueByIDObject(formID, recordID, crmFormFieldValue));
    }

    //  3
    @Operation(
            summary = "Create FormFieldValue autoGenerates RecordID",
            description = "<code>Create</code> <i><b>FormFieldValue AutoGenerates RecordID</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(path = "/{formID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> formInsFieldValueSPWithRecordID(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "<code>Basic</code> example for create form <i><b></b>10000002</i>",
                                                    value = "{\n" +
                                                            "  \"details\": [\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000001,\n" +
                                                            "      \"fieldValue\": \"Erfan Akhavan\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000002,\n" +
                                                            "      \"fieldValue\": 20\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000003,\n" +
                                                            "      \"fieldValue\": \"2003/02/14\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000004,\n" +
                                                            "      \"fieldValue\": 19\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000005,\n" +
                                                            "      \"fieldValue\": 1\n" +
                                                            "    }\n" +
                                                            "  ]\n" +
                                                            "}",
                                                    summary = "فرم مرخصی کارمندان"
                                            ),
                                            @ExampleObject(
                                                    name = "<code>Basic</code> example for create form <i><b></b>10000024</i>",
                                                    value = "{\n" +
                                                            "  \"details\": [\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000006,\n" +
                                                            "      \"fieldValue\": \"جگر مرغ دریایی\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000007,\n" +
                                                            "      \"fieldValue\": \"2022/10/17\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000008,\n" +
                                                            "      \"fieldValue\": 365214\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "       \"fieldID\": 10000101,\n" +
                                                            "      \"fieldValue\": 0\n" +
                                                            "    }\n" +
                                                            "  ]\n" +
                                                            "}",
                                                    summary = "فرم اطلاعات سفارشات"
                                            ),
                                            @ExampleObject(
                                                    name = "<code>Basic</code> example for create form <i><b></b>10000029</i>",
                                                    value = "{\n" +
                                                            "  \"details\": [\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000021,\n" +
                                                            "      \"fieldValue\": \"متن فیلد ۱\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000022,\n" +
                                                            "      \"fieldValue\":6841\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000023,\n" +
                                                            "      \"fieldValue\": 8655214\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000025,\n" +
                                                            "      \"fieldValue\":\"قهوه و بیسکوییت\"\n" +
                                                            "    }\n" +
                                                            ",\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000026,\n" +
                                                            "      \"fieldValue\": \"Sins\"\n" +
                                                            "    }\n" +
                                                            "  ]\n" +
                                                            "}",
                                                    summary = "فرم جدید اخوان"
                                            )
                                    }
                            )
                    }
            )
            @Valid @RequestBody CrmFormFieldValueWithMulti crmFormFieldValueWithMulti, @PathVariable BigDecimal formID
    ) {
        return ResponseEntity.ok(crmFormFieldValueRepository.crmInsFormFieldValueWithRecordID(formID,
                crmFormFieldValueWithMulti
        ));
    }

    //  4
//    @Operation(
//            summary = "Update FormFieldValue autoGenerates RecordID",
//            description = "<code>Update</code> <i><b>FormFieldValue AutoGenerates RecordID</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PutMapping(path = "/{formID}/{recordID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Map<String, Object>>> formUpdFieldValueSPWithRecordID(
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = {
//                            @Content(
//                                    examples = {
//                                            @ExampleObject(
//                                                    name = "<code>Basic</code> example for update form <i><b></b>10000002</i>",
//                                                    value = "{\n" +
//                                                            "  \"details\": [\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000001,\n" +
//                                                            "      \"fieldValue\": \"Erfan Akhavan\"\n" +
//                                                            "    },\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000002,\n" +
//                                                            "      \"fieldValue\": 20\n" +
//                                                            "    },\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000003,\n" +
//                                                            "      \"fieldValue\": \"2003/02/14\"\n" +
//                                                            "    },\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000004,\n" +
//                                                            "      \"fieldValue\": 19\n" +
//                                                            "    },\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000005,\n" +
//                                                            "      \"fieldValue\": 1\n" +
//                                                            "    }\n" +
//                                                            "  ]\n" +
//                                                            "}",
//                                                    summary = "فرم مرخصی کارمندان"
//                                            ),
//                                            @ExampleObject(
//                                                    name = "<code>Basic</code> example for update form <i><b></b>10000024</i>",
//                                                    value = "{\n" +
//                                                            "  \"details\": [\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000006,\n" +
//                                                            "      \"fieldValue\": \"جگر مرغ دریایی\"\n" +
//                                                            "    },\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000007,\n" +
//                                                            "      \"fieldValue\":\"2022/10/17\"\n" +
//                                                            "    },\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000008,\n" +
//                                                            "      \"fieldValue\": 365214\n" +
//                                                            "    }\n" +
//                                                            "  ]\n" +
//                                                            "}",
//                                                    summary = "فرم اطلاعات سفارشات"
//                                            ),
//                                            @ExampleObject(
//                                                    name = "<code>Basic</code> example for update form <i><b></b>10000029</i>",
//                                                    value = "{\n" +
//                                                            "  \"details\": [\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000021,\n" +
//                                                            "      \"fieldValue\": \"متن فیلد ۱\"\n" +
//                                                            "    },\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000022,\n" +
//                                                            "      \"fieldValue\":6841\n" +
//                                                            "    },\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000023,\n" +
//                                                            "      \"fieldValue\": 8655214\n" +
//                                                            "    },\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000025,\n" +
//                                                            "      \"fieldValue\":\"قهوه و بیسکوییت\"\n" +
//                                                            "    }\n" +
//                                                            ",\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000026,\n" +
//                                                            "      \"fieldValue\": \"Sins\"\n" +
//                                                            "    }\n" +
//                                                            "  ]\n" +
//                                                            "}",
//                                                    summary = "فرم جدید اخوان"
//                                            )
//                                    }
//                            )
//                    }
//            )
//            @Valid @RequestBody CrmFormFieldValueWithMulti crmFormFieldValueWithMulti, @PathVariable BigDecimal formID, @PathVariable BigDecimal recordID
//    ) {
//        return ResponseEntity.ok(crmFormFieldValueRepository.crmUpdFormFieldValueWithRecordID(formID, recordID, crmFormFieldValueWithMulti
//        ));
//    }

    @Operation(
            summary = "Update FormFieldValue autoGenerates RecordID",
            description = "<code>Update</code> <i><b>FormFieldValue AutoGenerates RecordID</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(path = "/{formID}/{recordID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> formUpdFieldValueSPWithRecordID(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "<code>Basic</code> example for update form <i><b></b>10000002</i>",
                                                    value = "{\n" +
                                                            "  \"details\": [\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000001,\n" +
                                                            "      \"fieldValue\": \"Erfan Akhavan\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000002,\n" +
                                                            "      \"fieldValue\": 20\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000003,\n" +
                                                            "      \"fieldValue\": \"2003/02/14\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000004,\n" +
                                                            "      \"fieldValue\": 19\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000005,\n" +
                                                            "      \"fieldValue\": 1\n" +
                                                            "    }\n" +
                                                            "  ]\n" +
                                                            "}",
                                                    summary = "فرم مرخصی کارمندان"
                                            ),
                                            @ExampleObject(
                                                    name = "<code>Basic</code> example for update form <i><b></b>10000024</i>",
                                                    value = "{\n" +
                                                            "  \"details\": [\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000006,\n" +
                                                            "      \"fieldValue\": \"جگر مرغ دریایی\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000007,\n" +
                                                            "      \"fieldValue\": \"2022/10/17\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000008,\n" +
                                                            "      \"fieldValue\": 365214\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "       \"fieldID\": 10000101,\n" +
                                                            "      \"fieldValue\": 0\n" +
                                                            "    }\n" +
                                                            "  ]\n" +
                                                            "}",
                                                    summary = "فرم اطلاعات سفارشات"
                                            ),
                                            @ExampleObject(
                                                    name = "<code>Basic</code> example for update form <i><b></b>10000029</i>",
                                                    value = "{\n" +
                                                            "  \"details\": [\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000021,\n" +
                                                            "      \"fieldValue\": \"متن فیلد ۱\"\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000022,\n" +
                                                            "      \"fieldValue\":6841\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000023,\n" +
                                                            "      \"fieldValue\": 8655214\n" +
                                                            "    },\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000025,\n" +
                                                            "      \"fieldValue\":\"قهوه و بیسکوییت\"\n" +
                                                            "    }\n" +
                                                            ",\n" +
                                                            "    {\n" +
                                                            "      \"fieldID\": 10000026,\n" +
                                                            "      \"fieldValue\": \"Sins\"\n" +
                                                            "    }\n" +
                                                            "  ]\n" +
                                                            "}",
                                                    summary = "فرم جدید اخوان"
                                            )
                                    }
                            )
                    }
            )
            @Valid @RequestBody CrmFormFieldValueWithMulti crmFormFieldValueWithMulti, @PathVariable BigDecimal formID, @PathVariable BigDecimal recordID
    ) {
        return ResponseEntity.ok(crmFormFieldValueRepository.crmUpdFormFieldValueWithRecordID(formID, recordID, crmFormFieldValueWithMulti
        ));
    }

    //  5
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete FormFieldValue",
            description = "<code>Delete</code> <i><b>FormFieldValue<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{formID}/{recordID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> formFieldValueDelSP(@PathVariable BigDecimal formID, @PathVariable BigDecimal recordID) {
        crmFormFieldValueRepository.crmDelFormFieldValue(formID, recordID);
        return ResponseEntity.noContent().build();
    }

    // 6
    @Operation(
            summary = "Retrieve FormFieldValue meta",
            description = "<code>Retrieve</code> <i><b>FormFieldValue</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/meta/{formID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meta> meta(@PathVariable BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {

        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);

//        final List<CrmCategory> crmCategories = crmCategoryRepository.(formID);
        final List<CrmFormBuilder> crmCategoryList = crmFormBuilderRepository.crmShowCategoryFormID(formID);

        CrmFormBuilder crmFormBuilder = new CrmFormBuilder();
        crmFormBuilder.setFormID(formID);
        final List<CrmFormBuilder> crmFormBuilders2 = crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder);

        return ResponseEntity
                .ok()
                .body(crmFormFieldValueRepository.meta(formID, crmFormFieldValue, crmFormBuilders, crmCategoryList, crmFormBuilders2));
    }
//
//    @Operation(
//            summary = "Retrieve FormFieldValue metaTESTING",
//            description = "<code>Retrieve</code> <i><b>FormFieldValue</b></i> metaTESTING",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(path = "/metatesting/{formID}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Meta> metaTESTING(@PathVariable BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
//
//        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
//
////        final List<CrmCategory> crmCategories = crmCategoryRepository.(formID);
//        final List<CrmFormBuilder> crmCategoryList = crmFormBuilderRepository.crmShowCategoryFormID(formID);
//
//        CrmFormBuilder crmFormBuilder = new CrmFormBuilder();
//        crmFormBuilder.setFormID(formID);
//        final List<CrmFormBuilder> crmFormBuilders2 = crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder);
//
//        return ResponseEntity
//                .ok()
//                .body(crmFormFieldValueRepository.metaTesting(formID, crmFormFieldValue, crmFormBuilders, crmCategoryList, crmFormBuilders2));
//    }


//    @Operation(
//            summary = "Retrieve FormFieldValue metaTESTING NEXT",
//            description = "<code>Retrieve</code> <i><b>FormFieldValue</b></i> metaTESTING NEXT",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(path = "/metatesting/next/{formID}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Meta> metaTESTINGNext(@PathVariable BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
//
//        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
//
////        final List<CrmCategory> crmCategories = crmCategoryRepository.(formID);
//        final List<CrmFormBuilder> crmCategoryList = crmFormBuilderRepository.crmShowCategoryFormID(formID);
//
//        CrmFormBuilder crmFormBuilder = new CrmFormBuilder();
//        crmFormBuilder.setFormID(formID);
//        final List<CrmFormBuilder> crmFormBuilders2 = crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder);
//
//        return ResponseEntity
//                .ok()
//                .body(crmFormFieldValueRepository.metaTestingNext(formID, crmFormFieldValue, crmFormBuilders, crmCategoryList, crmFormBuilders2));
//    }

//    @Operation(
//            summary = "Create FormFieldValue",
//            description = "<code>Create</code> <i><b>FormFieldValue</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Map<String, Object>>> formInsFieldValueSP(
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = {
//                            @Content(
//                                    examples = {
//                                            @ExampleObject(
//                                                    "{\n" +
//                                                            "  \"header\": {\n" +
//                                                            "    \"recordID\": 10000001\n" +
//                                                            "  },\n" +
//                                                            "  \"details\": [\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000001,\n" +
//                                                            "      \"fieldValue\": \"Erfan Akhavan\"\n" +
//                                                            "    },\n" +
//                                                            "  {\n" +
//                                                            "    \"fieldID\": 10000002,\n" +
//                                                            "    \"fieldValue\": 20\n" +
//                                                            "  },\n" +
//                                                            "      {\n" +
//                                                            "     \"fieldID\": 10000003,\n" +
//                                                            "      \"fieldValue\": \"2003/02/14\"\n" +
//                                                            "       },\n" +
//                                                            "     {\n" +
//                                                            "     \"fieldID\": 10000004,\n" +
//                                                            "     \"fieldValue\": 19\n" +
//                                                            "      },\n" +
//                                                            "     {\n" +
//                                                            "     \"fieldID\": 10000005,\n" +
//                                                            "     \"fieldValue\": 1\n" +
//                                                            "    }\n" +
//                                                            "  ]\n" +
//                                                            "}\n"
//                                            )
//                                    }
//                            )
//                    }
//            )
//            @Valid @RequestBody CrmFormFieldValueWithMulti crmFormFieldValueWithMulti
//    ) {
//        return ResponseEntity.ok(crmFormFieldValueRepository.crmInsFormFieldValue(
//                crmFormFieldValueWithMulti
//        ));
//    }


//    @Operation(
//            summary = "Create FormFieldValue RecordID",
//            description = "<code>Create</code> <i><b>FormFieldValue with RecordID embedded</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(path = "/hey/{formID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Map<String, Object>>> formInsFieldValueSPRecordID(
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = {
//                            @Content(
//                                    examples = {
//                                            @ExampleObject("{\n" +
//                                                    "  \"details\": [\n" +
//                                                    "    {\n" +
//                                                    "      \"fieldID\": 10000001,\n" +
//                                                    "      \"fieldValue\": \"Erfan Akhavan\"\n" +
//                                                    "    },\n" +
//                                                    "    {\n" +
//                                                    "      \"fieldID\": 10000002,\n" +
//                                                    "      \"fieldValue\": 20\n" +
//                                                    "    },\n" +
//                                                    "    {\n" +
//                                                    "      \"fieldID\": 10000003,\n" +
//                                                    "      \"fieldValue\": \"2003/02/14\"\n" +
//                                                    "    },\n" +
//                                                    "    {\n" +
//                                                    "      \"fieldID\": 10000004,\n" +
//                                                    "      \"fieldValue\": 19\n" +
//                                                    "    },\n" +
//                                                    "    {\n" +
//                                                    "      \"fieldID\": 10000005,\n" +
//                                                    "      \"fieldValue\": 1\n" +
//                                                    "    }\n" +
//                                                    "  ]\n" +
//                                                    "}")
//                                    }
//                            )
//                    }
//            )
//            @PathVariable BigDecimal formID, @Valid @RequestBody CrmFormFieldValueWithMulti crmFormFieldValueWithMulti
//    ) {
//        return ResponseEntity.ok(crmFormFieldValueRepository.crmInsFormFieldValueWithRecordID(formID,
//                crmFormFieldValueWithMulti
//        ));
//    }


    /**
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     * Testing block
     */
//    @Operation(
//            summary = "Retrieve all FormFieldValues TEST",
//            description = "<code>Retrieve</code> all <i><b>FormFieldValues TEST</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Map<String, Object>>> formFieldValuesTest(@Parameter BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
////        System.out.println("here is " + ResponseEntity
////                .ok()
////                .body(crmFormFieldValueRepository.crmShowFormFieldValueTest(formID, crmFormFieldValue)));
//
////        BigDecimal fieldID = BigDecimal.valueOf(10000006);
////        System.out.println("This was: " + crmFormBuilderRepository.crmShowFormBuilderByFormID(formID));
////        CrmFormBuilder crmFormBuilder = new CrmFormBuilder();
////        crmFormBuilder.setFormID(formID);
////        crmFormBuilder.setFieldID(fieldID);
////        System.out.println("This was: " + crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder));
////        System.out.println("Response entity was: " + ResponseEntity.ok().body(crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder)));
////        final List<CrmFormBuilder> crmFormBuilders1 = crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder);
////        crmFormBuilders1.get(0).getFieldTitleLatin();
//
////        System.out.println("Latin: " + crmFormBuilders1.get(0).getFieldTitleLatin());
////        final List<Map<String, Object>> maps1 = crmFormFieldValueRepository.crmShowFormFieldValueTest(formID, crmFormFieldValue);
//
//        return
//                ResponseEntity
//                        .ok()
//                        .body(crmFormFieldValueRepository.crmShowFormFieldValueTest(formID, crmFormFieldValue));
//    }
//
//
//    @Operation(
//            summary = "Retrieve FormFieldValue",
//            description = "<code>Retrieve</code> all <i><b>FormFieldValue</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(path = "/test/single", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Map<String, Object>>> formFieldValuesTestByID(@Parameter BigDecimal formID, @Parameter BigDecimal recordID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
//        return
//                ResponseEntity
//                        .ok()
//                        .body(crmFormFieldValueRepository.crmShowFormFieldValueTestByID(formID, recordID, crmFormFieldValue));
//    }
//
//
//    // HERE ##############################
//    @Operation(
//            summary = "Retrieve FormFieldValue ",
//            description = "<code>Retrieve</code> all <i><b>FormFieldValue</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(path = "/test/single/3", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Map<String, Object>>> formFieldValuesTestByID2(@Parameter BigDecimal formID, @Parameter BigDecimal recordID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
//        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
//
//        return
//                ResponseEntity
//                        .ok()
//                        .body(crmFormFieldValueRepository.crmShowFormFieldValueTestByID3(formID, recordID, crmFormFieldValue, crmFormBuilders));
//    }
//
////
////    @GetMapping(value = "/meta3", produces = MediaType.APPLICATION_JSON_VALUE)
////    public ResponseEntity<Meta> meta3(@Parameter BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
////
////        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
////
////        return ResponseEntity
////                .ok()
////                .body(crmFormFieldValueRepository.meta3(formID, crmFormFieldValue, crmFormBuilders));
////    }
//    // HERE ##############################
//
//
//    @Operation(
//            summary = "Create FormFieldValue none decimal",
//            description = "<code>Create</code> <i><b>FormFieldValue decimal</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(path = "/nonedecimal", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CrmFormFieldValueWithMulti> formInsFieldValueSPTest(
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = {
//                            @Content(
//                                    examples = {
//                                            @ExampleObject(
//                                                    "{\n" +
//                                                            "  \"header\": {\n" +
//                                                            "    \"recordID\": 6001\n" +
//                                                            "  },\n" +
//                                                            "  \"details\": [\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000001,\n" +
//                                                            "      \"fieldValue\": \"Erfan Akhavan\"\n" +
//                                                            "    },\n" +
//                                                            "  {\n" +
//                                                            "    \"fieldID\": 10000002,\n" +
//                                                            "    \"fieldValue\": 20\n" +
//                                                            "  },\n" +
//                                                            "      {\n" +
//                                                            "     \"fieldID\": 10000003,\n" +
//                                                            "      \"fieldValue\": \"2003/02/14\"\n" +
//                                                            "       },\n" +
//                                                            "     {\n" +
//                                                            "     \"fieldID\": 10000004,\n" +
//                                                            "     \"fieldValue\": 19\n" +
//                                                            "      },\n" +
//                                                            "     {\n" +
//                                                            "     \"fieldID\": 10000005,\n" +
//                                                            "     \"fieldValue\": 1\n" +
//                                                            "    }\n" +
//                                                            "  ]\n" +
//                                                            "}\n"
//                                            )
//                                    }
//                            )
//                    }
//            )
//            @Valid @RequestBody CrmFormFieldValueWithMulti crmFormFieldValueWithMulti
//    ) {
//        return ResponseEntity.ok(crmFormFieldValueRepository.crmInsFormFieldValueTest(
//                crmFormFieldValueWithMulti
//        ));
//    }
//
//
//    @Operation(
//            summary = "Create FormFieldValue Decimal",
//            description = "<code>Create</code> <i><b>FormFieldValue Decimal</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(path = "/decimal", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Map<String, Object>>> formInsFieldValueSPDecimal(
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = {
//                            @Content(
//                                    examples = {
//                                            @ExampleObject(
//                                                    "{\n" +
//                                                            "  \"header\": {\n" +
//                                                            "    \"recordID\": 6001\n" +
//                                                            "  },\n" +
//                                                            "  \"details\": [\n" +
//                                                            "    {\n" +
//                                                            "      \"fieldID\": 10000001,\n" +
//                                                            "      \"fieldValue\": \"Erfan Akhavan\"\n" +
//                                                            "    },\n" +
//                                                            "  {\n" +
//                                                            "    \"fieldID\": 10000002,\n" +
//                                                            "    \"fieldValue\": 20\n" +
//                                                            "  },\n" +
//                                                            "      {\n" +
//                                                            "     \"fieldID\": 10000003,\n" +
//                                                            "      \"fieldValue\": \"2003/02/14\"\n" +
//                                                            "       },\n" +
//                                                            "     {\n" +
//                                                            "     \"fieldID\": 10000004,\n" +
//                                                            "     \"fieldValue\": 19\n" +
//                                                            "      },\n" +
//                                                            "     {\n" +
//                                                            "     \"fieldID\": 10000005,\n" +
//                                                            "     \"fieldValue\": 1\n" +
//                                                            "    }\n" +
//                                                            "  ]\n" +
//                                                            "}\n"
//                                            )
//                                    }
//                            )
//                    }
//            )
//            @Valid @RequestBody CrmFormFieldValueWithMulti crmFormFieldValueWithMulti
//    ) {
//        return ResponseEntity.ok(crmFormFieldValueRepository.crmInsFormFieldValueTestDecimal(
//                crmFormFieldValueWithMulti
//        ));
//    }
//
//
//    @Operation(
//            summary = "Retrieve FormFieldValue meta",
//            description = "<code>Retrieve</code> <i><b>FormFieldValue</b></i> meta",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/metatest", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Meta> metaTest(@Parameter BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
//
//
////        default CrmFormBuilder crmShowFormBuilderByFormID(BigDecimal formID) {
////            List<TParameter<?>> tParameters = new ArrayList<>();
////            tParameters.add(new TParameter<>("Filter", " AND [Main].[FormID] =" + formID));
////            tParameters.add(new TParameter<>("OtherFilter", null));
////            tParameters.add(new TParameter<>("ServerFilter", null));
////            tParameters.add(new TParameter<>("YearFilter", null));
////            tParameters.add(new TParameter<>("UserAccessFilter", null));
////            tParameters.add(new TParameter<>("PageFilter", null));
////             showSP("CrmShowFormBuilder", tParameters, true).get(0);
////        }
//        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
//
////        for (int i = 0; i < crmFormBuilders.size(); i++) {
////            crmFormBuilders.get(i).ge
////        }
//
//        return ResponseEntity
//                .ok()
//                .body(crmFormFieldValueRepository.metaTest(formID, crmFormFieldValue, crmFormBuilders));
//    }
//
//
//    @Operation(
//            summary = "Retrieve FormFieldValue meta3",
//            description = "<code>Retrieve</code> <i><b>FormFieldValue</b></i> meta3",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/meta3", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Meta> meta3(@Parameter BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
//
//        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
//
//        return ResponseEntity
//                .ok()
//                .body(crmFormFieldValueRepository.meta3(formID, crmFormFieldValue, crmFormBuilders));
//    }
//
//
//    @Operation(
//            summary = "Retrieve Last RecordId",
//            description = "<code>Retrieve</code> all <i><b>Last RecordId</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(path = "/lastrecordid/{formID}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<BigDecimal> formFieldValuesLastRecordID(@PathVariable BigDecimal formID) {
//        return
//                ResponseEntity
//                        .ok()
//                        .body(crmFormFieldValueRepository.lastRecordId(formID));
//    }
//
//    /**
//     *
//     *     @GetMapping(produces = "application/json;charset=utf-8")
//     *     public ResponseEntity<List<Map<String, Object>>> saleReportPlan(
//     *             @RequestParam() String[] srIDs,
//     *             @RequestParam() BigDecimal yearID,
//     *             @RequestParam() String fromDate,
//     *             @RequestParam() String toDate,
//     *             @RequestParam() int reportLevel) {
//     *         return ResponseEntity
//     *                 .ok()
//     *                 .body(saleReportPlanRepository.saleReportPlan(srIDs, yearID, fromDate, toDate, reportLevel));
//     *     }
//     *
//     *
//     * @param crmFormFieldValue
//     * @param formID
//     * @param userID
//     * @return
//     */
//    /****************************************************************************************************************************************************************************** */
////    @Operation(
////            summary = "Retrieve all FormFieldValues",
////            description = "<code>Retrieve</code> all <i><b>FormFieldValues</b></i>",
////            security = @SecurityRequirement(name = "bearerAuth")
////    )
////    @GetMapping(produces = "application/json;charset=utf-8")
////    public ResponseEntity<List<CrmFormFieldValue>> formFieldValues(@ParameterObject CrmFormFieldValue crmFormFieldValue, @Parameter BigDecimal formID, @Parameter BigDecimal userID) {
////        System.out.println("here is " + ResponseEntity
////                .ok()
////                .body(crmFormFieldValueRepository.crmShowFormFieldValue(crmFormFieldValue, formID, userID)));
////
////        return ResponseEntity
////                .ok()
////                .body(crmFormFieldValueRepository.crmShowFormFieldValue(crmFormFieldValue, formID, userID));
////    }
//
//
//    @Operation(
//            summary = "Retrieve FormFieldValue meta original",
//            description = "<code>Retrieve</code> <i><b>FormFieldValue</b></i> meta original",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(path = "/meta/original/{formID}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Meta> metaOriginal(@PathVariable BigDecimal formID, @ParameterObject CrmFormFieldValue crmFormFieldValue) {
//
//        final List<CrmFormBuilder> crmFormBuilders = crmFormBuilderRepository.crmShowFormBuilderByFormID(formID);
//
//        return ResponseEntity
//                .ok()
//                .body(crmFormFieldValueRepository.metaOriginalTest(formID, crmFormFieldValue, crmFormBuilders));
//    }
//
//

}
